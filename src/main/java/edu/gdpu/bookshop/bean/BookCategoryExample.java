package edu.gdpu.bookshop.bean;

import java.util.ArrayList;
import java.util.List;

public class BookCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookCategoryExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrIsNull() {
            addCriterion("category_attr is null");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrIsNotNull() {
            addCriterion("category_attr is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrEqualTo(String value) {
            addCriterion("category_attr =", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrNotEqualTo(String value) {
            addCriterion("category_attr <>", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrGreaterThan(String value) {
            addCriterion("category_attr >", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrGreaterThanOrEqualTo(String value) {
            addCriterion("category_attr >=", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrLessThan(String value) {
            addCriterion("category_attr <", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrLessThanOrEqualTo(String value) {
            addCriterion("category_attr <=", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrLike(String value) {
            addCriterion("category_attr like", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrNotLike(String value) {
            addCriterion("category_attr not like", value, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrIn(List<String> values) {
            addCriterion("category_attr in", values, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrNotIn(List<String> values) {
            addCriterion("category_attr not in", values, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrBetween(String value1, String value2) {
            addCriterion("category_attr between", value1, value2, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andCategoryAttrNotBetween(String value1, String value2) {
            addCriterion("category_attr not between", value1, value2, "categoryAttr");
            return (Criteria) this;
        }

        public Criteria andBookNumsIsNull() {
            addCriterion("book_nums is null");
            return (Criteria) this;
        }

        public Criteria andBookNumsIsNotNull() {
            addCriterion("book_nums is not null");
            return (Criteria) this;
        }

        public Criteria andBookNumsEqualTo(Integer value) {
            addCriterion("book_nums =", value, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsNotEqualTo(Integer value) {
            addCriterion("book_nums <>", value, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsGreaterThan(Integer value) {
            addCriterion("book_nums >", value, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_nums >=", value, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsLessThan(Integer value) {
            addCriterion("book_nums <", value, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsLessThanOrEqualTo(Integer value) {
            addCriterion("book_nums <=", value, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsIn(List<Integer> values) {
            addCriterion("book_nums in", values, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsNotIn(List<Integer> values) {
            addCriterion("book_nums not in", values, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsBetween(Integer value1, Integer value2) {
            addCriterion("book_nums between", value1, value2, "bookNums");
            return (Criteria) this;
        }

        public Criteria andBookNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("book_nums not between", value1, value2, "bookNums");
            return (Criteria) this;
        }

        public Criteria andIsEbookIsNull() {
            addCriterion("is_ebook is null");
            return (Criteria) this;
        }

        public Criteria andIsEbookIsNotNull() {
            addCriterion("is_ebook is not null");
            return (Criteria) this;
        }

        public Criteria andIsEbookEqualTo(Byte value) {
            addCriterion("is_ebook =", value, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookNotEqualTo(Byte value) {
            addCriterion("is_ebook <>", value, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookGreaterThan(Byte value) {
            addCriterion("is_ebook >", value, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_ebook >=", value, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookLessThan(Byte value) {
            addCriterion("is_ebook <", value, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookLessThanOrEqualTo(Byte value) {
            addCriterion("is_ebook <=", value, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookIn(List<Byte> values) {
            addCriterion("is_ebook in", values, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookNotIn(List<Byte> values) {
            addCriterion("is_ebook not in", values, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookBetween(Byte value1, Byte value2) {
            addCriterion("is_ebook between", value1, value2, "isEbook");
            return (Criteria) this;
        }

        public Criteria andIsEbookNotBetween(Byte value1, Byte value2) {
            addCriterion("is_ebook not between", value1, value2, "isEbook");
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