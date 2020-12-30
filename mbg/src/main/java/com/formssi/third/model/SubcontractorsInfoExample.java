package com.formssi.third.model;

import java.util.ArrayList;
import java.util.List;

public class SubcontractorsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubcontractorsInfoExample() {
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

        public Criteria andSubcontractorsIdIsNull() {
            addCriterion("SUBCONTRACTORS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdIsNotNull() {
            addCriterion("SUBCONTRACTORS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdEqualTo(Integer value) {
            addCriterion("SUBCONTRACTORS_ID =", value, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdNotEqualTo(Integer value) {
            addCriterion("SUBCONTRACTORS_ID <>", value, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdGreaterThan(Integer value) {
            addCriterion("SUBCONTRACTORS_ID >", value, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUBCONTRACTORS_ID >=", value, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdLessThan(Integer value) {
            addCriterion("SUBCONTRACTORS_ID <", value, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdLessThanOrEqualTo(Integer value) {
            addCriterion("SUBCONTRACTORS_ID <=", value, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdIn(List<Integer> values) {
            addCriterion("SUBCONTRACTORS_ID in", values, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdNotIn(List<Integer> values) {
            addCriterion("SUBCONTRACTORS_ID not in", values, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdBetween(Integer value1, Integer value2) {
            addCriterion("SUBCONTRACTORS_ID between", value1, value2, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SUBCONTRACTORS_ID not between", value1, value2, "subcontractorsId");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameIsNull() {
            addCriterion("SUBCONTRACTORS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameIsNotNull() {
            addCriterion("SUBCONTRACTORS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_NAME =", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameNotEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_NAME <>", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameGreaterThan(String value) {
            addCriterion("SUBCONTRACTORS_NAME >", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameGreaterThanOrEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_NAME >=", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameLessThan(String value) {
            addCriterion("SUBCONTRACTORS_NAME <", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameLessThanOrEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_NAME <=", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameLike(String value) {
            addCriterion("SUBCONTRACTORS_NAME like", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameNotLike(String value) {
            addCriterion("SUBCONTRACTORS_NAME not like", value, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameIn(List<String> values) {
            addCriterion("SUBCONTRACTORS_NAME in", values, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameNotIn(List<String> values) {
            addCriterion("SUBCONTRACTORS_NAME not in", values, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameBetween(String value1, String value2) {
            addCriterion("SUBCONTRACTORS_NAME between", value1, value2, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsNameNotBetween(String value1, String value2) {
            addCriterion("SUBCONTRACTORS_NAME not between", value1, value2, "subcontractorsName");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaIsNull() {
            addCriterion("SUBCONTRACTORS_AREA is null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaIsNotNull() {
            addCriterion("SUBCONTRACTORS_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_AREA =", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaNotEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_AREA <>", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaGreaterThan(String value) {
            addCriterion("SUBCONTRACTORS_AREA >", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaGreaterThanOrEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_AREA >=", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaLessThan(String value) {
            addCriterion("SUBCONTRACTORS_AREA <", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaLessThanOrEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_AREA <=", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaLike(String value) {
            addCriterion("SUBCONTRACTORS_AREA like", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaNotLike(String value) {
            addCriterion("SUBCONTRACTORS_AREA not like", value, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaIn(List<String> values) {
            addCriterion("SUBCONTRACTORS_AREA in", values, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaNotIn(List<String> values) {
            addCriterion("SUBCONTRACTORS_AREA not in", values, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaBetween(String value1, String value2) {
            addCriterion("SUBCONTRACTORS_AREA between", value1, value2, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsAreaNotBetween(String value1, String value2) {
            addCriterion("SUBCONTRACTORS_AREA not between", value1, value2, "subcontractorsArea");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesIsNull() {
            addCriterion("SUBCONTRACTORS_STATES is null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesIsNotNull() {
            addCriterion("SUBCONTRACTORS_STATES is not null");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_STATES =", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesNotEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_STATES <>", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesGreaterThan(String value) {
            addCriterion("SUBCONTRACTORS_STATES >", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesGreaterThanOrEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_STATES >=", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesLessThan(String value) {
            addCriterion("SUBCONTRACTORS_STATES <", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesLessThanOrEqualTo(String value) {
            addCriterion("SUBCONTRACTORS_STATES <=", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesLike(String value) {
            addCriterion("SUBCONTRACTORS_STATES like", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesNotLike(String value) {
            addCriterion("SUBCONTRACTORS_STATES not like", value, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesIn(List<String> values) {
            addCriterion("SUBCONTRACTORS_STATES in", values, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesNotIn(List<String> values) {
            addCriterion("SUBCONTRACTORS_STATES not in", values, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesBetween(String value1, String value2) {
            addCriterion("SUBCONTRACTORS_STATES between", value1, value2, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andSubcontractorsStatesNotBetween(String value1, String value2) {
            addCriterion("SUBCONTRACTORS_STATES not between", value1, value2, "subcontractorsStates");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIsNull() {
            addCriterion("WORKER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIsNotNull() {
            addCriterion("WORKER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeEqualTo(String value) {
            addCriterion("WORKER_TYPE =", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotEqualTo(String value) {
            addCriterion("WORKER_TYPE <>", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeGreaterThan(String value) {
            addCriterion("WORKER_TYPE >", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WORKER_TYPE >=", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLessThan(String value) {
            addCriterion("WORKER_TYPE <", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLessThanOrEqualTo(String value) {
            addCriterion("WORKER_TYPE <=", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLike(String value) {
            addCriterion("WORKER_TYPE like", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotLike(String value) {
            addCriterion("WORKER_TYPE not like", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIn(List<String> values) {
            addCriterion("WORKER_TYPE in", values, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotIn(List<String> values) {
            addCriterion("WORKER_TYPE not in", values, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeBetween(String value1, String value2) {
            addCriterion("WORKER_TYPE between", value1, value2, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotBetween(String value1, String value2) {
            addCriterion("WORKER_TYPE not between", value1, value2, "workerType");
            return (Criteria) this;
        }

        public Criteria andPrincipalAIsNull() {
            addCriterion("PRINCIPAL_A is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalAIsNotNull() {
            addCriterion("PRINCIPAL_A is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalAEqualTo(Integer value) {
            addCriterion("PRINCIPAL_A =", value, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalANotEqualTo(Integer value) {
            addCriterion("PRINCIPAL_A <>", value, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalAGreaterThan(Integer value) {
            addCriterion("PRINCIPAL_A >", value, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalAGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRINCIPAL_A >=", value, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalALessThan(Integer value) {
            addCriterion("PRINCIPAL_A <", value, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalALessThanOrEqualTo(Integer value) {
            addCriterion("PRINCIPAL_A <=", value, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalAIn(List<Integer> values) {
            addCriterion("PRINCIPAL_A in", values, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalANotIn(List<Integer> values) {
            addCriterion("PRINCIPAL_A not in", values, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalABetween(Integer value1, Integer value2) {
            addCriterion("PRINCIPAL_A between", value1, value2, "principalA");
            return (Criteria) this;
        }

        public Criteria andPrincipalANotBetween(Integer value1, Integer value2) {
            addCriterion("PRINCIPAL_A not between", value1, value2, "principalA");
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

        public Criteria andPrincipalBIsNull() {
            addCriterion("PRINCIPAL_B is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalBIsNotNull() {
            addCriterion("PRINCIPAL_B is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalBEqualTo(Integer value) {
            addCriterion("PRINCIPAL_B =", value, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBNotEqualTo(Integer value) {
            addCriterion("PRINCIPAL_B <>", value, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBGreaterThan(Integer value) {
            addCriterion("PRINCIPAL_B >", value, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRINCIPAL_B >=", value, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBLessThan(Integer value) {
            addCriterion("PRINCIPAL_B <", value, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBLessThanOrEqualTo(Integer value) {
            addCriterion("PRINCIPAL_B <=", value, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBIn(List<Integer> values) {
            addCriterion("PRINCIPAL_B in", values, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBNotIn(List<Integer> values) {
            addCriterion("PRINCIPAL_B not in", values, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBBetween(Integer value1, Integer value2) {
            addCriterion("PRINCIPAL_B between", value1, value2, "principalB");
            return (Criteria) this;
        }

        public Criteria andPrincipalBNotBetween(Integer value1, Integer value2) {
            addCriterion("PRINCIPAL_B not between", value1, value2, "principalB");
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