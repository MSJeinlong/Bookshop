package edu.gdpu.bookshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BsUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BsUserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("cellphone =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("cellphone <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("cellphone >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("cellphone <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("cellphone <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLike(String value) {
            addCriterion("cellphone like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("cellphone not like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("cellphone in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("cellphone not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("cellphone between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("cellphone not between", value1, value2, "cellphone");
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

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andProvince1IsNull() {
            addCriterion("province1 is null");
            return (Criteria) this;
        }

        public Criteria andProvince1IsNotNull() {
            addCriterion("province1 is not null");
            return (Criteria) this;
        }

        public Criteria andProvince1EqualTo(String value) {
            addCriterion("province1 =", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1NotEqualTo(String value) {
            addCriterion("province1 <>", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1GreaterThan(String value) {
            addCriterion("province1 >", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1GreaterThanOrEqualTo(String value) {
            addCriterion("province1 >=", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1LessThan(String value) {
            addCriterion("province1 <", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1LessThanOrEqualTo(String value) {
            addCriterion("province1 <=", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1Like(String value) {
            addCriterion("province1 like", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1NotLike(String value) {
            addCriterion("province1 not like", value, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1In(List<String> values) {
            addCriterion("province1 in", values, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1NotIn(List<String> values) {
            addCriterion("province1 not in", values, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1Between(String value1, String value2) {
            addCriterion("province1 between", value1, value2, "province1");
            return (Criteria) this;
        }

        public Criteria andProvince1NotBetween(String value1, String value2) {
            addCriterion("province1 not between", value1, value2, "province1");
            return (Criteria) this;
        }

        public Criteria andCity1IsNull() {
            addCriterion("city1 is null");
            return (Criteria) this;
        }

        public Criteria andCity1IsNotNull() {
            addCriterion("city1 is not null");
            return (Criteria) this;
        }

        public Criteria andCity1EqualTo(String value) {
            addCriterion("city1 =", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotEqualTo(String value) {
            addCriterion("city1 <>", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1GreaterThan(String value) {
            addCriterion("city1 >", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1GreaterThanOrEqualTo(String value) {
            addCriterion("city1 >=", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1LessThan(String value) {
            addCriterion("city1 <", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1LessThanOrEqualTo(String value) {
            addCriterion("city1 <=", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1Like(String value) {
            addCriterion("city1 like", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotLike(String value) {
            addCriterion("city1 not like", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1In(List<String> values) {
            addCriterion("city1 in", values, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotIn(List<String> values) {
            addCriterion("city1 not in", values, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1Between(String value1, String value2) {
            addCriterion("city1 between", value1, value2, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotBetween(String value1, String value2) {
            addCriterion("city1 not between", value1, value2, "city1");
            return (Criteria) this;
        }

        public Criteria andDistrict1IsNull() {
            addCriterion("district1 is null");
            return (Criteria) this;
        }

        public Criteria andDistrict1IsNotNull() {
            addCriterion("district1 is not null");
            return (Criteria) this;
        }

        public Criteria andDistrict1EqualTo(String value) {
            addCriterion("district1 =", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1NotEqualTo(String value) {
            addCriterion("district1 <>", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1GreaterThan(String value) {
            addCriterion("district1 >", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1GreaterThanOrEqualTo(String value) {
            addCriterion("district1 >=", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1LessThan(String value) {
            addCriterion("district1 <", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1LessThanOrEqualTo(String value) {
            addCriterion("district1 <=", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1Like(String value) {
            addCriterion("district1 like", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1NotLike(String value) {
            addCriterion("district1 not like", value, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1In(List<String> values) {
            addCriterion("district1 in", values, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1NotIn(List<String> values) {
            addCriterion("district1 not in", values, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1Between(String value1, String value2) {
            addCriterion("district1 between", value1, value2, "district1");
            return (Criteria) this;
        }

        public Criteria andDistrict1NotBetween(String value1, String value2) {
            addCriterion("district1 not between", value1, value2, "district1");
            return (Criteria) this;
        }

        public Criteria andStreet1IsNull() {
            addCriterion("street1 is null");
            return (Criteria) this;
        }

        public Criteria andStreet1IsNotNull() {
            addCriterion("street1 is not null");
            return (Criteria) this;
        }

        public Criteria andStreet1EqualTo(String value) {
            addCriterion("street1 =", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1NotEqualTo(String value) {
            addCriterion("street1 <>", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1GreaterThan(String value) {
            addCriterion("street1 >", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1GreaterThanOrEqualTo(String value) {
            addCriterion("street1 >=", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1LessThan(String value) {
            addCriterion("street1 <", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1LessThanOrEqualTo(String value) {
            addCriterion("street1 <=", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1Like(String value) {
            addCriterion("street1 like", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1NotLike(String value) {
            addCriterion("street1 not like", value, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1In(List<String> values) {
            addCriterion("street1 in", values, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1NotIn(List<String> values) {
            addCriterion("street1 not in", values, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1Between(String value1, String value2) {
            addCriterion("street1 between", value1, value2, "street1");
            return (Criteria) this;
        }

        public Criteria andStreet1NotBetween(String value1, String value2) {
            addCriterion("street1 not between", value1, value2, "street1");
            return (Criteria) this;
        }

        public Criteria andProvince2IsNull() {
            addCriterion("province2 is null");
            return (Criteria) this;
        }

        public Criteria andProvince2IsNotNull() {
            addCriterion("province2 is not null");
            return (Criteria) this;
        }

        public Criteria andProvince2EqualTo(String value) {
            addCriterion("province2 =", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2NotEqualTo(String value) {
            addCriterion("province2 <>", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2GreaterThan(String value) {
            addCriterion("province2 >", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2GreaterThanOrEqualTo(String value) {
            addCriterion("province2 >=", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2LessThan(String value) {
            addCriterion("province2 <", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2LessThanOrEqualTo(String value) {
            addCriterion("province2 <=", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2Like(String value) {
            addCriterion("province2 like", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2NotLike(String value) {
            addCriterion("province2 not like", value, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2In(List<String> values) {
            addCriterion("province2 in", values, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2NotIn(List<String> values) {
            addCriterion("province2 not in", values, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2Between(String value1, String value2) {
            addCriterion("province2 between", value1, value2, "province2");
            return (Criteria) this;
        }

        public Criteria andProvince2NotBetween(String value1, String value2) {
            addCriterion("province2 not between", value1, value2, "province2");
            return (Criteria) this;
        }

        public Criteria andCity2IsNull() {
            addCriterion("city2 is null");
            return (Criteria) this;
        }

        public Criteria andCity2IsNotNull() {
            addCriterion("city2 is not null");
            return (Criteria) this;
        }

        public Criteria andCity2EqualTo(String value) {
            addCriterion("city2 =", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotEqualTo(String value) {
            addCriterion("city2 <>", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2GreaterThan(String value) {
            addCriterion("city2 >", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2GreaterThanOrEqualTo(String value) {
            addCriterion("city2 >=", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2LessThan(String value) {
            addCriterion("city2 <", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2LessThanOrEqualTo(String value) {
            addCriterion("city2 <=", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2Like(String value) {
            addCriterion("city2 like", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotLike(String value) {
            addCriterion("city2 not like", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2In(List<String> values) {
            addCriterion("city2 in", values, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotIn(List<String> values) {
            addCriterion("city2 not in", values, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2Between(String value1, String value2) {
            addCriterion("city2 between", value1, value2, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotBetween(String value1, String value2) {
            addCriterion("city2 not between", value1, value2, "city2");
            return (Criteria) this;
        }

        public Criteria andDistrict2IsNull() {
            addCriterion("district2 is null");
            return (Criteria) this;
        }

        public Criteria andDistrict2IsNotNull() {
            addCriterion("district2 is not null");
            return (Criteria) this;
        }

        public Criteria andDistrict2EqualTo(String value) {
            addCriterion("district2 =", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2NotEqualTo(String value) {
            addCriterion("district2 <>", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2GreaterThan(String value) {
            addCriterion("district2 >", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2GreaterThanOrEqualTo(String value) {
            addCriterion("district2 >=", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2LessThan(String value) {
            addCriterion("district2 <", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2LessThanOrEqualTo(String value) {
            addCriterion("district2 <=", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2Like(String value) {
            addCriterion("district2 like", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2NotLike(String value) {
            addCriterion("district2 not like", value, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2In(List<String> values) {
            addCriterion("district2 in", values, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2NotIn(List<String> values) {
            addCriterion("district2 not in", values, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2Between(String value1, String value2) {
            addCriterion("district2 between", value1, value2, "district2");
            return (Criteria) this;
        }

        public Criteria andDistrict2NotBetween(String value1, String value2) {
            addCriterion("district2 not between", value1, value2, "district2");
            return (Criteria) this;
        }

        public Criteria andStreet2IsNull() {
            addCriterion("street2 is null");
            return (Criteria) this;
        }

        public Criteria andStreet2IsNotNull() {
            addCriterion("street2 is not null");
            return (Criteria) this;
        }

        public Criteria andStreet2EqualTo(String value) {
            addCriterion("street2 =", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2NotEqualTo(String value) {
            addCriterion("street2 <>", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2GreaterThan(String value) {
            addCriterion("street2 >", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2GreaterThanOrEqualTo(String value) {
            addCriterion("street2 >=", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2LessThan(String value) {
            addCriterion("street2 <", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2LessThanOrEqualTo(String value) {
            addCriterion("street2 <=", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2Like(String value) {
            addCriterion("street2 like", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2NotLike(String value) {
            addCriterion("street2 not like", value, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2In(List<String> values) {
            addCriterion("street2 in", values, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2NotIn(List<String> values) {
            addCriterion("street2 not in", values, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2Between(String value1, String value2) {
            addCriterion("street2 between", value1, value2, "street2");
            return (Criteria) this;
        }

        public Criteria andStreet2NotBetween(String value1, String value2) {
            addCriterion("street2 not between", value1, value2, "street2");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNull() {
            addCriterion("cardno is null");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNotNull() {
            addCriterion("cardno is not null");
            return (Criteria) this;
        }

        public Criteria andCardnoEqualTo(String value) {
            addCriterion("cardno =", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotEqualTo(String value) {
            addCriterion("cardno <>", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThan(String value) {
            addCriterion("cardno >", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThanOrEqualTo(String value) {
            addCriterion("cardno >=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThan(String value) {
            addCriterion("cardno <", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThanOrEqualTo(String value) {
            addCriterion("cardno <=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLike(String value) {
            addCriterion("cardno like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotLike(String value) {
            addCriterion("cardno not like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoIn(List<String> values) {
            addCriterion("cardno in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotIn(List<String> values) {
            addCriterion("cardno not in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoBetween(String value1, String value2) {
            addCriterion("cardno between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotBetween(String value1, String value2) {
            addCriterion("cardno not between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
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