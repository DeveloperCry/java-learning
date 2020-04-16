package com.learning.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Permission {
    /**
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Integer ID;

    /**
     * 权限名称
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private String NAME;

    /**
     * 请求路径
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private String URI;

    /**
     * 菜单请求方法
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private String METHOD;

    /**
     * 菜单图标
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private String ICON;

    /**
     * 权限
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private String PERMISSION;

    /**
     * 菜单状态(1是true，代表可用；0是false，代表不可用)
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Byte STATUS;

    /**
     * 排序
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Integer SORT;

    /**
     * 父级菜单
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Integer PARENT_ID;

    /**
     * 备注
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private String REMARK;

    /**
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Date CREATE_DATE;

    /**
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Integer CREATE_USER;

    /**
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Date EDIT_DATE;

    /**
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private Integer EDIT_USER;

    /**
     *
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    private String TYPE;


    /**
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", NAME=").append(NAME);
        sb.append(", URI=").append(URI);
        sb.append(", METHOD=").append(METHOD);
        sb.append(", ICON=").append(ICON);
        sb.append(", PERMISSION=").append(PERMISSION);
        sb.append(", STATUS=").append(STATUS);
        sb.append(", SORT=").append(SORT);
        sb.append(", PARENT_ID=").append(PARENT_ID);
        sb.append(", REMARK=").append(REMARK);
        sb.append(", CREATE_DATE=").append(CREATE_DATE);
        sb.append(", CREATE_USER=").append(CREATE_USER);
        sb.append(", EDIT_DATE=").append(EDIT_DATE);
        sb.append(", EDIT_USER=").append(EDIT_USER);
        sb.append(", TYPE=").append(TYPE);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
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
            && (this.getMETHOD() == null ? other.getMETHOD() == null : this.getMETHOD().equals(other.getMETHOD()))
            && (this.getICON() == null ? other.getICON() == null : this.getICON().equals(other.getICON()))
            && (this.getPERMISSION() == null ? other.getPERMISSION() == null : this.getPERMISSION().equals(other.getPERMISSION()))
            && (this.getSTATUS() == null ? other.getSTATUS() == null : this.getSTATUS().equals(other.getSTATUS()))
            && (this.getSORT() == null ? other.getSORT() == null : this.getSORT().equals(other.getSORT()))
            && (this.getPARENT_ID() == null ? other.getPARENT_ID() == null : this.getPARENT_ID().equals(other.getPARENT_ID()))
            && (this.getREMARK() == null ? other.getREMARK() == null : this.getREMARK().equals(other.getREMARK()))
            && (this.getCREATE_DATE() == null ? other.getCREATE_DATE() == null : this.getCREATE_DATE().equals(other.getCREATE_DATE()))
            && (this.getCREATE_USER() == null ? other.getCREATE_USER() == null : this.getCREATE_USER().equals(other.getCREATE_USER()))
            && (this.getEDIT_DATE() == null ? other.getEDIT_DATE() == null : this.getEDIT_DATE().equals(other.getEDIT_DATE()))
            && (this.getEDIT_USER() == null ? other.getEDIT_USER() == null : this.getEDIT_USER().equals(other.getEDIT_USER()))
            && (this.getTYPE() == null ? other.getTYPE() == null : this.getTYPE().equals(other.getTYPE()));
    }

    /**
     *
     * @mbg.generated Tue Apr 14 12:03:32 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getNAME() == null) ? 0 : getNAME().hashCode());
        result = prime * result + ((getURI() == null) ? 0 : getURI().hashCode());
        result = prime * result + ((getMETHOD() == null) ? 0 : getMETHOD().hashCode());
        result = prime * result + ((getICON() == null) ? 0 : getICON().hashCode());
        result = prime * result + ((getPERMISSION() == null) ? 0 : getPERMISSION().hashCode());
        result = prime * result + ((getSTATUS() == null) ? 0 : getSTATUS().hashCode());
        result = prime * result + ((getSORT() == null) ? 0 : getSORT().hashCode());
        result = prime * result + ((getPARENT_ID() == null) ? 0 : getPARENT_ID().hashCode());
        result = prime * result + ((getREMARK() == null) ? 0 : getREMARK().hashCode());
        result = prime * result + ((getCREATE_DATE() == null) ? 0 : getCREATE_DATE().hashCode());
        result = prime * result + ((getCREATE_USER() == null) ? 0 : getCREATE_USER().hashCode());
        result = prime * result + ((getEDIT_DATE() == null) ? 0 : getEDIT_DATE().hashCode());
        result = prime * result + ((getEDIT_USER() == null) ? 0 : getEDIT_USER().hashCode());
        result = prime * result + ((getTYPE() == null) ? 0 : getTYPE().hashCode());
        return result;
    }
}