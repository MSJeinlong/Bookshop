package edu.gdpu.bookshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_name is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_name =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_name >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_name <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_name like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_name not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("admin_name in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("admin_name not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNull() {
            addCriterion("login_status is null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNotNull() {
            addCriterion("login_status is not null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusEqualTo(Boolean value) {
            addCriterion("login_status =", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotEqualTo(Boolean value) {
            addCriterion("login_status <>", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThan(Boolean value) {
            addCriterion("login_status >", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("login_status >=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThan(Boolean value) {
            addCriterion("login_status <", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("login_status <=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIn(List<Boolean> values) {
            addCriterion("login_status in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotIn(List<Boolean> values) {
            addCriterion("login_status not in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("login_status between", value1, value2, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("login_status not between", value1, value2, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeIsNull() {
            addCriterion("lastest_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeIsNotNull() {
            addCriterion("lastest_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeEqualTo(Date value) {
            addCriterion("lastest_login_time =", value, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeNotEqualTo(Date value) {
            addCriterion("lastest_login_time <>", value, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeGreaterThan(Date value) {
            addCriterion("lastest_login_time >", value, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastest_login_time >=", value, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeLessThan(Date value) {
            addCriterion("lastest_login_time <", value, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastest_login_time <=", value, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeIn(List<Date> values) {
            addCriterion("lastest_login_time in", values, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeNotIn(List<Date> values) {
            addCriterion("lastest_login_time not in", values, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeBetween(Date value1, Date value2) {
            addCriterion("lastest_login_time between", value1, value2, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastestLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastest_login_time not between", value1, value2, "lastestLoginTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeIsNull() {
            addCriterion("sign_out_time is null");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeIsNotNull() {
            addCriterion("sign_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeEqualTo(Date value) {
            addCriterion("sign_out_time =", value, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeNotEqualTo(Date value) {
            addCriterion("sign_out_time <>", value, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeGreaterThan(Date value) {
            addCriterion("sign_out_time >", value, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_out_time >=", value, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeLessThan(Date value) {
            addCriterion("sign_out_time <", value, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_out_time <=", value, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeIn(List<Date> values) {
            addCriterion("sign_out_time in", values, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeNotIn(List<Date> values) {
            addCriterion("sign_out_time not in", values, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeBetween(Date value1, Date value2) {
            addCriterion("sign_out_time between", value1, value2, "signOutTime");
            return (Criteria) this;
        }

        public Criteria andSignOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_out_time not between", value1, value2, "signOutTime");
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