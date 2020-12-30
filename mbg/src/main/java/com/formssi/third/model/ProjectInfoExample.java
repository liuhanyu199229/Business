package com.formssi.third.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProjectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("PROJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("PROJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("PROJECT_ID =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("PROJECT_ID <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("PROJECT_ID >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROJECT_ID >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("PROJECT_ID <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROJECT_ID <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("PROJECT_ID in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("PROJECT_ID not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("PROJECT_ID between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROJECT_ID not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("PROJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("PROJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("PROJECT_NAME =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("PROJECT_NAME <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("PROJECT_NAME >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("PROJECT_NAME <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("PROJECT_NAME like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("PROJECT_NAME not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("PROJECT_NAME in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("PROJECT_NAME not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("PROJECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("PROJECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("PROJECT_TYPE =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("PROJECT_TYPE <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("PROJECT_TYPE >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_TYPE >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("PROJECT_TYPE <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_TYPE <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("PROJECT_TYPE like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("PROJECT_TYPE not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("PROJECT_TYPE in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("PROJECT_TYPE not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("PROJECT_TYPE between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("PROJECT_TYPE not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIsNull() {
            addCriterion("PROJECT_AREA is null");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIsNotNull() {
            addCriterion("PROJECT_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAreaEqualTo(String value) {
            addCriterion("PROJECT_AREA =", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotEqualTo(String value) {
            addCriterion("PROJECT_AREA <>", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaGreaterThan(String value) {
            addCriterion("PROJECT_AREA >", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_AREA >=", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaLessThan(String value) {
            addCriterion("PROJECT_AREA <", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_AREA <=", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaLike(String value) {
            addCriterion("PROJECT_AREA like", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotLike(String value) {
            addCriterion("PROJECT_AREA not like", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIn(List<String> values) {
            addCriterion("PROJECT_AREA in", values, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotIn(List<String> values) {
            addCriterion("PROJECT_AREA not in", values, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaBetween(String value1, String value2) {
            addCriterion("PROJECT_AREA between", value1, value2, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotBetween(String value1, String value2) {
            addCriterion("PROJECT_AREA not between", value1, value2, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectScaleIsNull() {
            addCriterion("PROJECT_SCALE is null");
            return (Criteria) this;
        }

        public Criteria andProjectScaleIsNotNull() {
            addCriterion("PROJECT_SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectScaleEqualTo(String value) {
            addCriterion("PROJECT_SCALE =", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotEqualTo(String value) {
            addCriterion("PROJECT_SCALE <>", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleGreaterThan(String value) {
            addCriterion("PROJECT_SCALE >", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_SCALE >=", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleLessThan(String value) {
            addCriterion("PROJECT_SCALE <", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_SCALE <=", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleLike(String value) {
            addCriterion("PROJECT_SCALE like", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotLike(String value) {
            addCriterion("PROJECT_SCALE not like", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleIn(List<String> values) {
            addCriterion("PROJECT_SCALE in", values, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotIn(List<String> values) {
            addCriterion("PROJECT_SCALE not in", values, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleBetween(String value1, String value2) {
            addCriterion("PROJECT_SCALE between", value1, value2, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotBetween(String value1, String value2) {
            addCriterion("PROJECT_SCALE not between", value1, value2, "projectScale");
            return (Criteria) this;
        }

        public Criteria andContractSDateIsNull() {
            addCriterion("CONTRACT_S_DATE is null");
            return (Criteria) this;
        }

        public Criteria andContractSDateIsNotNull() {
            addCriterion("CONTRACT_S_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andContractSDateEqualTo(String value) {
            addCriterion("CONTRACT_S_DATE =", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateNotEqualTo(String value) {
            addCriterion("CONTRACT_S_DATE <>", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateGreaterThan(String value) {
            addCriterion("CONTRACT_S_DATE >", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_S_DATE >=", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateLessThan(String value) {
            addCriterion("CONTRACT_S_DATE <", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_S_DATE <=", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateLike(String value) {
            addCriterion("CONTRACT_S_DATE like", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateNotLike(String value) {
            addCriterion("CONTRACT_S_DATE not like", value, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateIn(List<String> values) {
            addCriterion("CONTRACT_S_DATE in", values, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateNotIn(List<String> values) {
            addCriterion("CONTRACT_S_DATE not in", values, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateBetween(String value1, String value2) {
            addCriterion("CONTRACT_S_DATE between", value1, value2, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractSDateNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_S_DATE not between", value1, value2, "contractSDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateIsNull() {
            addCriterion("CONTRACT_E_DATE is null");
            return (Criteria) this;
        }

        public Criteria andContractEDateIsNotNull() {
            addCriterion("CONTRACT_E_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andContractEDateEqualTo(String value) {
            addCriterion("CONTRACT_E_DATE =", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateNotEqualTo(String value) {
            addCriterion("CONTRACT_E_DATE <>", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateGreaterThan(String value) {
            addCriterion("CONTRACT_E_DATE >", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_E_DATE >=", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateLessThan(String value) {
            addCriterion("CONTRACT_E_DATE <", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_E_DATE <=", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateLike(String value) {
            addCriterion("CONTRACT_E_DATE like", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateNotLike(String value) {
            addCriterion("CONTRACT_E_DATE not like", value, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateIn(List<String> values) {
            addCriterion("CONTRACT_E_DATE in", values, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateNotIn(List<String> values) {
            addCriterion("CONTRACT_E_DATE not in", values, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateBetween(String value1, String value2) {
            addCriterion("CONTRACT_E_DATE between", value1, value2, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractEDateNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_E_DATE not between", value1, value2, "contractEDate");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNull() {
            addCriterion("CONTRACT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNotNull() {
            addCriterion("CONTRACT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmountEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_AMOUNT =", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_AMOUNT <>", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThan(BigDecimal value) {
            addCriterion("CONTRACT_AMOUNT >", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_AMOUNT >=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThan(BigDecimal value) {
            addCriterion("CONTRACT_AMOUNT <", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_AMOUNT <=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_AMOUNT in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_AMOUNT not in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_AMOUNT between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_AMOUNT not between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("MANAGER_ID is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("MANAGER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("MANAGER_ID =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("MANAGER_ID <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("MANAGER_ID >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MANAGER_ID >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("MANAGER_ID <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("MANAGER_ID <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("MANAGER_ID in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("MANAGER_ID not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("MANAGER_ID between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MANAGER_ID not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andPhoneAIsNull() {
            addCriterion("PHONE_A is null");
            return (Criteria) this;
        }

        public Criteria andPhoneAIsNotNull() {
            addCriterion("PHONE_A is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneAEqualTo(String value) {
            addCriterion("PHONE_A =", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotEqualTo(String value) {
            addCriterion("PHONE_A <>", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneAGreaterThan(String value) {
            addCriterion("PHONE_A >", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneAGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_A >=", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneALessThan(String value) {
            addCriterion("PHONE_A <", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneALessThanOrEqualTo(String value) {
            addCriterion("PHONE_A <=", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneALike(String value) {
            addCriterion("PHONE_A like", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotLike(String value) {
            addCriterion("PHONE_A not like", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneAIn(List<String> values) {
            addCriterion("PHONE_A in", values, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotIn(List<String> values) {
            addCriterion("PHONE_A not in", values, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneABetween(String value1, String value2) {
            addCriterion("PHONE_A between", value1, value2, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotBetween(String value1, String value2) {
            addCriterion("PHONE_A not between", value1, value2, "phoneA");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdIsNull() {
            addCriterion("DEPUTY_MANAGER_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdIsNotNull() {
            addCriterion("DEPUTY_MANAGER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdEqualTo(Integer value) {
            addCriterion("DEPUTY_MANAGER_ID =", value, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdNotEqualTo(Integer value) {
            addCriterion("DEPUTY_MANAGER_ID <>", value, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdGreaterThan(Integer value) {
            addCriterion("DEPUTY_MANAGER_ID >", value, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPUTY_MANAGER_ID >=", value, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdLessThan(Integer value) {
            addCriterion("DEPUTY_MANAGER_ID <", value, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPUTY_MANAGER_ID <=", value, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdIn(List<Integer> values) {
            addCriterion("DEPUTY_MANAGER_ID in", values, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdNotIn(List<Integer> values) {
            addCriterion("DEPUTY_MANAGER_ID not in", values, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPUTY_MANAGER_ID between", value1, value2, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andDeputyManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPUTY_MANAGER_ID not between", value1, value2, "deputyManagerId");
            return (Criteria) this;
        }

        public Criteria andPhoneBIsNull() {
            addCriterion("PHONE_B is null");
            return (Criteria) this;
        }

        public Criteria andPhoneBIsNotNull() {
            addCriterion("PHONE_B is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneBEqualTo(String value) {
            addCriterion("PHONE_B =", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotEqualTo(String value) {
            addCriterion("PHONE_B <>", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBGreaterThan(String value) {
            addCriterion("PHONE_B >", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_B >=", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBLessThan(String value) {
            addCriterion("PHONE_B <", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBLessThanOrEqualTo(String value) {
            addCriterion("PHONE_B <=", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBLike(String value) {
            addCriterion("PHONE_B like", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotLike(String value) {
            addCriterion("PHONE_B not like", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBIn(List<String> values) {
            addCriterion("PHONE_B in", values, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotIn(List<String> values) {
            addCriterion("PHONE_B not in", values, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBBetween(String value1, String value2) {
            addCriterion("PHONE_B between", value1, value2, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotBetween(String value1, String value2) {
            addCriterion("PHONE_B not between", value1, value2, "phoneB");
            return (Criteria) this;
        }

        public Criteria andHandleIdIsNull() {
            addCriterion("HANDLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andHandleIdIsNotNull() {
            addCriterion("HANDLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHandleIdEqualTo(Integer value) {
            addCriterion("HANDLE_ID =", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdNotEqualTo(Integer value) {
            addCriterion("HANDLE_ID <>", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdGreaterThan(Integer value) {
            addCriterion("HANDLE_ID >", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HANDLE_ID >=", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdLessThan(Integer value) {
            addCriterion("HANDLE_ID <", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdLessThanOrEqualTo(Integer value) {
            addCriterion("HANDLE_ID <=", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdIn(List<Integer> values) {
            addCriterion("HANDLE_ID in", values, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdNotIn(List<Integer> values) {
            addCriterion("HANDLE_ID not in", values, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdBetween(Integer value1, Integer value2) {
            addCriterion("HANDLE_ID between", value1, value2, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HANDLE_ID not between", value1, value2, "handleId");
            return (Criteria) this;
        }

        public Criteria andProjectStatesIsNull() {
            addCriterion("PROJECT_STATES is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatesIsNotNull() {
            addCriterion("PROJECT_STATES is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatesEqualTo(String value) {
            addCriterion("PROJECT_STATES =", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesNotEqualTo(String value) {
            addCriterion("PROJECT_STATES <>", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesGreaterThan(String value) {
            addCriterion("PROJECT_STATES >", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_STATES >=", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesLessThan(String value) {
            addCriterion("PROJECT_STATES <", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_STATES <=", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesLike(String value) {
            addCriterion("PROJECT_STATES like", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesNotLike(String value) {
            addCriterion("PROJECT_STATES not like", value, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesIn(List<String> values) {
            addCriterion("PROJECT_STATES in", values, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesNotIn(List<String> values) {
            addCriterion("PROJECT_STATES not in", values, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesBetween(String value1, String value2) {
            addCriterion("PROJECT_STATES between", value1, value2, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectStatesNotBetween(String value1, String value2) {
            addCriterion("PROJECT_STATES not between", value1, value2, "projectStates");
            return (Criteria) this;
        }

        public Criteria andProjectDesIsNull() {
            addCriterion("PROJECT_DES is null");
            return (Criteria) this;
        }

        public Criteria andProjectDesIsNotNull() {
            addCriterion("PROJECT_DES is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDesEqualTo(String value) {
            addCriterion("PROJECT_DES =", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotEqualTo(String value) {
            addCriterion("PROJECT_DES <>", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesGreaterThan(String value) {
            addCriterion("PROJECT_DES >", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_DES >=", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesLessThan(String value) {
            addCriterion("PROJECT_DES <", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_DES <=", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesLike(String value) {
            addCriterion("PROJECT_DES like", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotLike(String value) {
            addCriterion("PROJECT_DES not like", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesIn(List<String> values) {
            addCriterion("PROJECT_DES in", values, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotIn(List<String> values) {
            addCriterion("PROJECT_DES not in", values, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesBetween(String value1, String value2) {
            addCriterion("PROJECT_DES between", value1, value2, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotBetween(String value1, String value2) {
            addCriterion("PROJECT_DES not between", value1, value2, "projectDes");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(String value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(String value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(String value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(String value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLike(String value) {
            addCriterion("UPDATE_DATE like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotLike(String value) {
            addCriterion("UPDATE_DATE not like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<String> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<String> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(String value1, String value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(String value1, String value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("UPDATE_TIME like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("UPDATE_TIME not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}