package com.learning.demo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    /**
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private Integer ID;

    /**
     * 角色名称
     *
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private String NAME;

    /**
     * 角色状态(1是true，代表可用；0是false，代表不可用)
     *
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private String STATUS;

    /**
     * 备注
     *
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private String REMARK;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private Date CREATE_DATE;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private Integer CREATE_USER;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private Date EDIT_DATE;

    /**
     *
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    private Integer EDIT_USER;

    /**
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
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
        Role other = (Role) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getNAME() == null ? other.getNAME() == null : this.getNAME().equals(other.getNAME()))
            && (this.getSTATUS() == null ? other.getSTATUS() == null : this.getSTATUS().equals(other.getSTATUS()))
            && (this.getREMARK() == null ? other.getREMARK() == null : this.getREMARK().equals(other.getREMARK()))
            && (this.getCREATE_DATE() == null ? other.getCREATE_DATE() == null : this.getCREATE_DATE().equals(other.getCREATE_DATE()))
            && (this.getCREATE_USER() == null ? other.getCREATE_USER() == null : this.getCREATE_USER().equals(other.getCREATE_USER()))
            && (this.getEDIT_DATE() == null ? other.getEDIT_DATE() == null : this.getEDIT_DATE().equals(other.getEDIT_DATE()))
            && (this.getEDIT_USER() == null ? other.getEDIT_USER() == null : this.getEDIT_USER().equals(other.getEDIT_USER()));
    }

    /**
     *
     * @mbg.generated Sun Apr 12 23:50:42 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getNAME() == null) ? 0 : getNAME().hashCode());
        result = prime * result + ((getSTATUS() == null) ? 0 : getSTATUS().hashCode());
        result = prime * result + ((getREMARK() == null) ? 0 : getREMARK().hashCode());
        result = prime * result + ((getCREATE_DATE() == null) ? 0 : getCREATE_DATE().hashCode());
        result = prime * result + ((getCREATE_USER() == null) ? 0 : getCREATE_USER().hashCode());
        result = prime * result + ((getEDIT_DATE() == null) ? 0 : getEDIT_DATE().hashCode());
        result = prime * result + ((getEDIT_USER() == null) ? 0 : getEDIT_USER().hashCode());
        return result;
    }
}