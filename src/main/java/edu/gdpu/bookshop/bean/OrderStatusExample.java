package edu.gdpu.bookshop.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderStatusExample() {
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

        public Criteria andStatusIdIsNull() {
            addCriterion("status_id is null");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNotNull() {
            addCriterion("status_id is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIdEqualTo(Integer value) {
            addCriterion("status_id =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(Integer value) {
            addCriterion("status_id <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(Integer value) {
            addCriterion("status_id >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_id >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(Integer value) {
            addCriterion("status_id <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("status_id <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<Integer> values) {
            addCriterion("status_id in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<Integer> values) {
            addCriterion("status_id not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("status_id between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("status_id not between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNull() {
            addCriterion("status_name is null");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNotNull() {
            addCriterion("status_name is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNameEqualTo(String value) {
            addCriterion("status_name =", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotEqualTo(String value) {
            addCriterion("status_name <>", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThan(String value) {
            addCriterion("status_name >", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("status_name >=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThan(String value) {
            addCriterion("status_name <", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThanOrEqualTo(String value) {
            addCriterion("status_name <=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLike(String value) {
            addCriterion("status_name like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotLike(String value) {
            addCriterion("status_name not like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameIn(List<String> values) {
            addCriterion("status_name in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotIn(List<String> values) {
            addCriterion("status_name not in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameBetween(String value1, String value2) {
            addCriterion("status_name between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotBetween(String value1, String value2) {
            addCriterion("status_name not between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andSatusDescIsNull() {
            addCriterion("satus_desc is null");
            return (Criteria) this;
        }

        public Criteria andSatusDescIsNotNull() {
            addCriterion("satus_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSatusDescEqualTo(String value) {
            addCriterion("satus_desc =", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescNotEqualTo(String value) {
            addCriterion("satus_desc <>", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescGreaterThan(String value) {
            addCriterion("satus_desc >", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescGreaterThanOrEqualTo(String value) {
            addCriterion("satus_desc >=", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescLessThan(String value) {
            addCriterion("satus_desc <", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescLessThanOrEqualTo(String value) {
            addCriterion("satus_desc <=", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescLike(String value) {
            addCriterion("satus_desc like", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescNotLike(String value) {
            addCriterion("satus_desc not like", value, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescIn(List<String> values) {
            addCriterion("satus_desc in", values, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescNotIn(List<String> values) {
            addCriterion("satus_desc not in", values, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescBetween(String value1, String value2) {
            addCriterion("satus_desc between", value1, value2, "satusDesc");
            return (Criteria) this;
        }

        public Criteria andSatusDescNotBetween(String value1, String value2) {
            addCriterion("satus_desc not between", value1, value2, "satusDesc");
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