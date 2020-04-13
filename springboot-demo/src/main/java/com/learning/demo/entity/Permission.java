package com.learning.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Permission {
    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Integer ID;

    /**
     * 权限名称
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private String NAME;

    /**
     * 请求路径
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private String URI;

    /**
     * 添加权限
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Boolean CREATE;

    /**
     * 读权限
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Boolean READ;

    /**
     * 更新权限
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Boolean UPDATE;

    /**
     * 删除权限
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Boolean DELETE;

    /**
     * 菜单状态(1是true，代表可用；0是false，代表不可用)
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Boolean STATUS;

    /**
     * 备注
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private String REMARK;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Date CREATE_DATE;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Integer CREATE_USER;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Date EDIT_DATE;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    private Integer EDIT_USER;

    /**
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permission other = (Permission) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getNAME() == null ? other.getNAME() == null : this.getNAME().equals(other.getNAME()))
            && (this.getURI() == null ? other.getURI() == null : this.getURI().equals(other.getURI()))
            && (this.getCREATE() == null ? other.getCREATE() == null : this.getCREATE().equals(other.getCREATE()))
            && (this.getREAD() == null ? other.getREAD() == null : this.getREAD().equals(other.getREAD()))
            && (this.getUPDATE() == null ? other.getUPDATE() == null : this.getUPDATE().equals(other.getUPDATE()))
            && (this.getDELETE() == null ? other.getDELETE() == null : this.getDELETE().equals(other.getDELETE()))
            && (this.getSTATUS() == null ? other.getSTATUS() == null : this.getSTATUS().equals(other.getSTATUS()))
            && (this.getREMARK() == null ? other.getREMARK() == null : this.getREMARK().equals(other.getREMARK()))
            && (this.getCREATE_DATE() == null ? other.getCREATE_DATE() == null : this.getCREATE_DATE().equals(other.getCREATE_DATE()))
            && (this.getCREATE_USER() == null ? other.getCREATE_USER() == null : this.getCREATE_USER().equals(other.getCREATE_USER()))
            && (this.getEDIT_DATE() == null ? other.getEDIT_DATE() == null : this.getEDIT_DATE().equals(other.getEDIT_DATE()))
            && (this.getEDIT_USER() == null ? other.getEDIT_USER() == null : this.getEDIT_USER().equals(other.getEDIT_USER()));
    }

    /**
     *
     * @mbg.generated Sun Apr 12 23:49:50 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getNAME() == null) ? 0 : getNAME().hashCode());
        result = prime * result + ((getURI() == null) ? 0 : getURI().hashCode());
        result = prime * result + ((getCREATE() == null) ? 0 : getCREATE().hashCode());
        result = prime * result + ((getREAD() == null) ? 0 : getREAD().hashCode());
        result = prime * result + ((getUPDATE() == null) ? 0 : getUPDATE().hashCode());
        result = prime * result + ((getDELETE() == null) ? 0 : getDELETE().hashCode());
        result = prime * result + ((getSTATUS() == null) ? 0 : getSTATUS().hashCode());
        result = prime * result + ((getREMARK() == null) ? 0 : getREMARK().hashCode());
        result = prime * result + ((getCREATE_DATE() == null) ? 0 : getCREATE_DATE().hashCode());
        result = prime * result + ((getCREATE_USER() == null) ? 0 : getCREATE_USER().hashCode());
        result = prime * result + ((getEDIT_DATE() == null) ? 0 : getEDIT_DATE().hashCode());
        result = prime * result + ((getEDIT_USER() == null) ? 0 : getEDIT_USER().hashCode());
        return result;
    }
}