package com.dataman.pike.core.entity;

import java.util.Date;

public class FormElement {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.id
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.oper_id
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private Long operId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.name_cn
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private String nameCn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.name_en
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private String nameEn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.element_name
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private String elementName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.rules
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private String rules;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.placeholder
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private String placeholder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.value_dic
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private Long valueDic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.create_at
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private Date createAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.update_at
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private Date updateAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_form_element.creator
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    private Long creator;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.id
     *
     * @return the value of t_form_element.id
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.id
     *
     * @param id the value for t_form_element.id
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.oper_id
     *
     * @return the value of t_form_element.oper_id
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public Long getOperId() {
        return operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.oper_id
     *
     * @param operId the value for t_form_element.oper_id
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setOperId(Long operId) {
        this.operId = operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.name_cn
     *
     * @return the value of t_form_element.name_cn
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public String getNameCn() {
        return nameCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.name_cn
     *
     * @param nameCn the value for t_form_element.name_cn
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.name_en
     *
     * @return the value of t_form_element.name_en
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.name_en
     *
     * @param nameEn the value for t_form_element.name_en
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.element_name
     *
     * @return the value of t_form_element.element_name
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.element_name
     *
     * @param elementName the value for t_form_element.element_name
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setElementName(String elementName) {
        this.elementName = elementName == null ? null : elementName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.rules
     *
     * @return the value of t_form_element.rules
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public String getRules() {
        return rules;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.rules
     *
     * @param rules the value for t_form_element.rules
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.placeholder
     *
     * @return the value of t_form_element.placeholder
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.placeholder
     *
     * @param placeholder the value for t_form_element.placeholder
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder == null ? null : placeholder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.value_dic
     *
     * @return the value of t_form_element.value_dic
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public Long getValueDic() {
        return valueDic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.value_dic
     *
     * @param valueDic the value for t_form_element.value_dic
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setValueDic(Long valueDic) {
        this.valueDic = valueDic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.create_at
     *
     * @return the value of t_form_element.create_at
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.create_at
     *
     * @param createAt the value for t_form_element.create_at
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.update_at
     *
     * @return the value of t_form_element.update_at
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.update_at
     *
     * @param updateAt the value for t_form_element.update_at
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_form_element.creator
     *
     * @return the value of t_form_element.creator
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_form_element.creator
     *
     * @param creator the value for t_form_element.creator
     *
     * @mbg.generated Wed Oct 25 15:52:22 CST 2017
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }
}