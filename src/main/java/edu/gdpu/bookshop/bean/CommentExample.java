package edu.gdpu.bookshop.bean;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentDescIsNull() {
            addCriterion("comment_desc is null");
            return (Criteria) this;
        }

        public Criteria andCommentDescIsNotNull() {
            addCriterion("comment_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCommentDescEqualTo(String value) {
            addCriterion("comment_desc =", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescNotEqualTo(String value) {
            addCriterion("comment_desc <>", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescGreaterThan(String value) {
            addCriterion("comment_desc >", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescGreaterThanOrEqualTo(String value) {
            addCriterion("comment_desc >=", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescLessThan(String value) {
            addCriterion("comment_desc <", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescLessThanOrEqualTo(String value) {
            addCriterion("comment_desc <=", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescLike(String value) {
            addCriterion("comment_desc like", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescNotLike(String value) {
            addCriterion("comment_desc not like", value, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescIn(List<String> values) {
            addCriterion("comment_desc in", values, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescNotIn(List<String> values) {
            addCriterion("comment_desc not in", values, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescBetween(String value1, String value2) {
            addCriterion("comment_desc between", value1, value2, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentDescNotBetween(String value1, String value2) {
            addCriterion("comment_desc not between", value1, value2, "commentDesc");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIsNull() {
            addCriterion("comment_level is null");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIsNotNull() {
            addCriterion("comment_level is not null");
            return (Criteria) this;
        }

        public Criteria andCommentLevelEqualTo(Integer value) {
            addCriterion("comment_level =", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotEqualTo(Integer value) {
            addCriterion("comment_level <>", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelGreaterThan(Integer value) {
            addCriterion("comment_level >", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_level >=", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelLessThan(Integer value) {
            addCriterion("comment_level <", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("comment_level <=", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIn(List<Integer> values) {
            addCriterion("comment_level in", values, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotIn(List<Integer> values) {
            addCriterion("comment_level not in", values, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelBetween(Integer value1, Integer value2) {
            addCriterion("comment_level between", value1, value2, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_level not between", value1, value2, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentGradeIsNull() {
            addCriterion("comment_grade is null");
            return (Criteria) this;
        }

        public Criteria andCommentGradeIsNotNull() {
            addCriterion("comment_grade is not null");
            return (Criteria) this;
        }

        public Criteria andCommentGradeEqualTo(Integer value) {
            addCriterion("comment_grade =", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeNotEqualTo(Integer value) {
            addCriterion("comment_grade <>", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeGreaterThan(Integer value) {
            addCriterion("comment_grade >", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_grade >=", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeLessThan(Integer value) {
            addCriterion("comment_grade <", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeLessThanOrEqualTo(Integer value) {
            addCriterion("comment_grade <=", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeIn(List<Integer> values) {
            addCriterion("comment_grade in", values, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeNotIn(List<Integer> values) {
            addCriterion("comment_grade not in", values, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeBetween(Integer value1, Integer value2) {
            addCriterion("comment_grade between", value1, value2, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_grade not between", value1, value2, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
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