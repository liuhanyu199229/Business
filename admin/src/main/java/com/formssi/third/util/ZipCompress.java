package com.formssi.third.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;



/**
 * zip压缩工具类
 * lhy
 */
public class ZipCompress {
    /**
     *
     * 压缩文件,调用入口
     * @param src  源文件/目录
     * @param dest 压缩后的文件/目录
     *
     */
    public  void zip(String src, String dest) throws Exception
    {

        File srcFile = new File(src);
        File destFile = new File(dest);

        if (destFile.isDirectory())
        {
            /**
             * 构造压缩文件名。取当前文件/目录名称为压缩文件名。
             */
            String name = srcFile.getName();
            name = name.indexOf(".") > 0 ? name.substring(0, name.indexOf("."))
                    : name;

            name = name + ".zip";
            destFile = new File(destFile + "/" + name);

        }

        zipFileStart(srcFile, destFile);

        srcFile = null;
        destFile = null;

    }




    /**
     * 取得文件流，开始压缩文件
     * @param src    原文件流
     * @param dest   目标文件流
     */
    private  void zipFileStart(File src, File dest) throws Exception {

        FileOutputStream    fout = null;
        CheckedOutputStream chc = null;
        ZipOutputStream out = null;

        try
        {
            fout = new FileOutputStream(dest);
            chc = new CheckedOutputStream(fout, new CRC32());
            out = new ZipOutputStream(new BufferedOutputStream(chc));

            zipDo(out, src, src.getName());

            out.close();
            chc.close();
            fout.close();

        }
        catch ( Exception e)
        {
            throw e;
        }
        finally
        {
            if (fout != null) {
                fout.close();
            }
            fout = null;

            if (chc != null) {
                chc.close();
            }
            chc = null;

            if (out != null) {
                out.close();
            }
            out = null;

        }

    }

    /**
     * 递归压缩文件夹
     * @param out 输出流
     * @param srcFile 压缩文件名
     * @param path 压缩文件路径
     */
    private  void zipDo(ZipOutputStream out, File srcFile, String path) throws Exception{
        FileInputStream in = null;

        try
        {
            if (srcFile.isDirectory())
            {
                File[] f = srcFile.listFiles();

                out.putNextEntry(new org.apache.tools.zip.ZipEntry(path + "/"));
                path = "".equals(path) ? "" : path + "/";

                for (int i = 0; i < f.length; i++) {
                    zipDo(out, f[i], path + f[i].getName());
                }

            }
            else
            {
                out.putNextEntry(new org.apache.tools.zip.ZipEntry(path));

                in = new FileInputStream(srcFile);
                byte[] by2 = new byte[1024];
                int c;

                while ((c = in.read(by2)) != -1) {
                    out.write(by2, 0, c);
                }

            }

            if(in != null) {
                in.close();
            }
            in = null;

        } catch (IOException e)
        {
            e.printStackTrace();

        }
        finally
        {
            if(in != null) {
                in.close();
            }
            in = null;

        }

    }

    /**
     * 定义解压缩的需要的文件夹
     * @param directory
     * @param subDirectory
     */
    private  void createDirectory(String directory, String subDirectory) throws Exception
    {
        String dir[];
        File fl = new File(directory);

        try
        {
            if (subDirectory == "" && fl.exists() != true) {
                fl.mkdir();
            } else
            if (subDirectory != "")
            {
                dir = subDirectory.replace('\\', '/').split("/");

                for (int i = 0; i < dir.length; i++)
                {
                    File subFile = new File(directory + File.separator + dir[i]);

                    if (subFile.exists() == false) {
                        subFile.mkdir();
                    }

                    directory += File.separator + dir[i];
                }
            }

        }
        catch (Exception ex)
        {
            throw new Exception("ZIP 压缩创建文件夹错误!");

        }
    }

    /**
     * 解压缩zip文件的方法。
     * 特点：生成的文件保存在指定的目录。
     * @param zipFileName
     * @param outputDirectory
     */
    public  void unZip(String zipFileName, String outputDirectory)
            throws Exception
    {
        org.apache.tools.zip.ZipFile zipFile = null;
        InputStream in = null;
        FileOutputStream out = null;

        try
        {
            zipFile = new org.apache.tools.zip.ZipFile(zipFileName);
            java.util.Enumeration e = zipFile.getEntries();
            org.apache.tools.zip.ZipEntry zipEntry = null;

            createDirectory(outputDirectory, "");

            while (e.hasMoreElements())
            {
                zipEntry = (org.apache.tools.zip.ZipEntry) e.nextElement();

                if (zipEntry.isDirectory())
                {
                    String name = zipEntry.getName();

                    name = name.substring(0, name.length() - 1);

                    File f = new File(outputDirectory + File.separator + name);
                    f.mkdir();

                }
                else
                {
                    String fileName = zipEntry.getName();

                    fileName = fileName.replace('\\', '/');

                    if (fileName.indexOf("/") != -1)
                    {
                        createDirectory(outputDirectory, fileName.
                                substring(0,fileName.lastIndexOf("/")));

                        fileName = fileName.substring(
                                fileName.lastIndexOf("/") + 1, fileName.length());
                    }

                    File f = new File(outputDirectory + File.separator+ zipEntry.getName());

                    f.createNewFile();

                    in = zipFile.getInputStream(zipEntry);
                    out = new FileOutputStream(f);

                    byte[] by = new byte[1024];
                    int c;

                    while ((c = in.read(by)) != -1) {
                        out.write(by, 0, c);
                    }

                    out.close();
                    in.close();

                }
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        finally
        {
            if (zipFile != null) {
                zipFile.close();
            }

            if (out != null) {
                out.close();
            }

            if (in != null) {
                in.close();
            }

            out = null;
            zipFile = null;
            in = null;
        }

    }

    /**
     * 解压缩zip文件的方法;
     * 特点：生成的文件保存在指定的目录;返回解压的文件名
     * @param zipFileName
     * @param outputDirectory
     */
    public  String unZipOneFileBackName(String zipFileName, String outputDirectory)
            throws Exception
    {

        org.apache.tools.zip.ZipFile zipFile = null;
        InputStream in = null;
        FileOutputStream out = null;

        String destName = "";

        try
        {
            zipFile = new org.apache.tools.zip.ZipFile(zipFileName);

            java.util.Enumeration e = zipFile.getEntries();
            org.apache.tools.zip.ZipEntry zipEntry = null;

            while (e.hasMoreElements())
            {

                zipEntry = (org.apache.tools.zip.ZipEntry) e.nextElement();
                destName = outputDirectory + zipEntry.getName();

                File f = new File(destName);

                f.createNewFile();

                in = zipFile.getInputStream(zipEntry);
                out = new FileOutputStream(f);

                byte[] by = new byte[1024];
                int c;

                while ((c = in.read(by)) != -1)
                {
                    out.write(by, 0, c);
                }

                out.close();
                in.close();

            }
        }
        catch (Exception ex)
        {
            throw ex;

        } finally
        {
            if (zipFile != null) {
                zipFile.close();
            }

            if (out != null) {
                out.close();
            }

            if (in != null) {
                in.close();
            }

            out = null;
            zipFile = null;
            in = null;

        }
        return destName;
    }


    public  ArrayList<String> unZipMQSC(String zipFileName, String outputDirectory)
            throws Exception
    {
        ArrayList<String> rlt = new ArrayList<String>();
        org.apache.tools.zip.ZipFile zipFile = null;
        InputStream in = null;
        FileOutputStream out = null;

        String destName = "";

        try
        {
            zipFile = new org.apache.tools.zip.ZipFile(zipFileName);

            java.util.Enumeration e = zipFile.getEntries();
            org.apache.tools.zip.ZipEntry zipEntry = null;

            while (e.hasMoreElements())
            {

                zipEntry = (org.apache.tools.zip.ZipEntry) e.nextElement();
                destName = outputDirectory + zipEntry.getName();

                File f = new File(destName);

                f.createNewFile();

                in = zipFile.getInputStream(zipEntry);
                out = new FileOutputStream(f);

                byte[] by = new byte[1024];
                int c;

                while ((c = in.read(by)) != -1)
                {
                    out.write(by, 0, c);
                }

                out.close();
                in.close();
                rlt.add(destName);
            }
        }
        catch (Exception ex)
        {
            throw ex;

        } finally
        {
            if (zipFile != null) {
                zipFile.close();
            }

            if (out != null) {
                out.close();
            }

            if (in != null) {
                in.close();
            }

            out = null;
            zipFile = null;
            in = null;

        }
        return rlt;
    }



    /**
     * 解压缩zip文件的方法。
     * 特点：生成的文件保存在指定的文件。
     * @param zipFileName
     * @param destFile
     */
    public  void unZipOneFile(String zipFileName, String destFile)
            throws Exception
    {
        org.apache.tools.zip.ZipFile zipFile = null;
        InputStream in = null;
        FileOutputStream out = null;

        try
        {
            zipFile = new org.apache.tools.zip.ZipFile(zipFileName);
            java.util.Enumeration e = zipFile.getEntries();
            org.apache.tools.zip.ZipEntry zipEntry = null;

            if (e.hasMoreElements())
            {
                zipEntry = (org.apache.tools.zip.ZipEntry) e.nextElement();
                File f = new File(destFile);

                f.createNewFile();

                in = zipFile.getInputStream(zipEntry);
                out = new FileOutputStream(f);

                byte[] by = new byte[1024];
                int c;

                while ((c = in.read(by)) != -1)
                {
                    out.write(by, 0, c);
                }

                out.close();
                in.close();

            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        finally
        {
            if (zipFile != null) {
                zipFile.close();
            }

            if (out != null) {
                out.close();
            }

            if (in != null) {
                in.close();
            }

            out = null;
            zipFile = null;
            in = null;

        }
    }

    /**
     * 多个文件压缩
     * @param srcfile File[]  需要压缩的文件列表
     * @param zipfile File    压缩后的文件
     * @throws IOException
     */
    public static void ZipFiles(String[] srcfile, String zipfile) throws Exception {
        ZipOutputStream out=null;
        FileInputStream in=null;
        byte[] buf = new byte[1024];
        try {
            File fileZip=new File(zipfile);
            out = new ZipOutputStream(new FileOutputStream(fileZip));
            for (int i = 0; i < srcfile.length; i++) {
                File file=new File(srcfile[i]);
                in = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while ( (len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            if (in != null) {
                in.close();
            }
            in = null;

            if (out != null) {
                out.close();
            }
            out = null;
        }
    }


    public static  void main(String[] args) throws Exception {
        ZipCompress  zipCompress = new ZipCompress();
        zipCompress.zip("D:/pgp/WARES.ZKKJ.20191120.00.P","D:/pgp/in/WARES.ZKKJ.20191120.00.P.ZIP");

        String[] srcfile={"D:/abc/1.txt","D:/abc/2.txt","D:/abc/3.txt","D:/abc/4.txt"};
        String zipfile="d:\\abc\\abhgv.zip";
        try {
            ZipFiles(srcfile, zipfile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
