package com.learning.spring.enity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("BLOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("BLOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("BLOG_ID =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("BLOG_ID <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("BLOG_ID >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BLOG_ID >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("BLOG_ID <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("BLOG_ID <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("BLOG_ID in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("BLOG_ID not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("BLOG_ID between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BLOG_ID not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("AUTHOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("AUTHOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("AUTHOR_ID =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("AUTHOR_ID <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("AUTHOR_ID >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTHOR_ID >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("AUTHOR_ID <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("AUTHOR_ID <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("AUTHOR_ID in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("AUTHOR_ID not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("AUTHOR_ID between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTHOR_ID not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andSectionIsNull() {
            addCriterion("SECTION is null");
            return (Criteria) this;
        }

        public Criteria andSectionIsNotNull() {
            addCriterion("SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEqualTo(String value) {
            addCriterion("SECTION =", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotEqualTo(String value) {
            addCriterion("SECTION <>", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThan(String value) {
            addCriterion("SECTION >", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThanOrEqualTo(String value) {
            addCriterion("SECTION >=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThan(String value) {
            addCriterion("SECTION <", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThanOrEqualTo(String value) {
            addCriterion("SECTION <=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLike(String value) {
            addCriterion("SECTION like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotLike(String value) {
            addCriterion("SECTION not like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionIn(List<String> values) {
            addCriterion("SECTION in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotIn(List<String> values) {
            addCriterion("SECTION not in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionBetween(String value1, String value2) {
            addCriterion("SECTION between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotBetween(String value1, String value2) {
            addCriterion("SECTION not between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("SUBJECT =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("SUBJECT <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("SUBJECT >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("SUBJECT <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("SUBJECT like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("SUBJECT not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("SUBJECT in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("SUBJECT not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("SUBJECT between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("SUBJECT not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andDraftIsNull() {
            addCriterion("DRAFT is null");
            return (Criteria) this;
        }

        public Criteria andDraftIsNotNull() {
            addCriterion("DRAFT is not null");
            return (Criteria) this;
        }

        public Criteria andDraftEqualTo(String value) {
            addCriterion("DRAFT =", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftNotEqualTo(String value) {
            addCriterion("DRAFT <>", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftGreaterThan(String value) {
            addCriterion("DRAFT >", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftGreaterThanOrEqualTo(String value) {
            addCriterion("DRAFT >=", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftLessThan(String value) {
            addCriterion("DRAFT <", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftLessThanOrEqualTo(String value) {
            addCriterion("DRAFT <=", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftLike(String value) {
            addCriterion("DRAFT like", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftNotLike(String value) {
            addCriterion("DRAFT not like", value, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftIn(List<String> values) {
            addCriterion("DRAFT in", values, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftNotIn(List<String> values) {
            addCriterion("DRAFT not in", values, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftBetween(String value1, String value2) {
            addCriterion("DRAFT between", value1, value2, "draft");
            return (Criteria) this;
        }

        public Criteria andDraftNotBetween(String value1, String value2) {
            addCriterion("DRAFT not between", value1, value2, "draft");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("BODY is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("BODY is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("BODY =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("BODY <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("BODY >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("BODY >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("BODY <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("BODY <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("BODY like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("BODY not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("BODY in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("BODY not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("BODY between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("BODY not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andCreatedOnIsNull() {
            addCriterion("CREATED_ON is null");
            return (Criteria) this;
        }

        public Criteria andCreatedOnIsNotNull() {
            addCriterion("CREATED_ON is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedOnEqualTo(Date value) {
            addCriterion("CREATED_ON =", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnNotEqualTo(Date value) {
            addCriterion("CREATED_ON <>", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnGreaterThan(Date value) {
            addCriterion("CREATED_ON >", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_ON >=", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnLessThan(Date value) {
            addCriterion("CREATED_ON <", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_ON <=", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnIn(List<Date> values) {
            addCriterion("CREATED_ON in", values, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnNotIn(List<Date> values) {
            addCriterion("CREATED_ON not in", values, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnBetween(Date value1, Date value2) {
            addCriterion("CREATED_ON between", value1, value2, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_ON not between", value1, value2, "createdOn");
            return (Criteria) this;
        }

        public Criteria andEditDateIsNull() {
            addCriterion("EDIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEditDateIsNotNull() {
            addCriterion("EDIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEditDateEqualTo(Date value) {
            addCriterion("EDIT_DATE =", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateNotEqualTo(Date value) {
            addCriterion("EDIT_DATE <>", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateGreaterThan(Date value) {
            addCriterion("EDIT_DATE >", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EDIT_DATE >=", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateLessThan(Date value) {
            addCriterion("EDIT_DATE <", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateLessThanOrEqualTo(Date value) {
            addCriterion("EDIT_DATE <=", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateIn(List<Date> values) {
            addCriterion("EDIT_DATE in", values, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateNotIn(List<Date> values) {
            addCriterion("EDIT_DATE not in", values, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateBetween(Date value1, Date value2) {
            addCriterion("EDIT_DATE between", value1, value2, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateNotBetween(Date value1, Date value2) {
            addCriterion("EDIT_DATE not between", value1, value2, "editDate");
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