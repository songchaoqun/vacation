package com.lyq.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_mem")
public class Members {
     //会员表
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Integer membersId;   //会员Id

      private String  membersName;  //会员名称

      @Transient
      private String    staffName;
      @Transient
      private String    createDate;
      @Transient
      private String    duetoDate;
      @Transient
      private String    pName;

      public String getStaffName() {
            return staffName;
      }

      public void setStaffName(String staffName) {
            this.staffName = staffName;
      }

      public String getCreateDate() {
            return createDate;
      }

      public void setCreateDate(String createDate) {
            this.createDate = createDate;
      }

      public String getDuetoDate() {
            return duetoDate;
      }

      public void setDuetoDate(String duetoDate) {
            this.duetoDate = duetoDate;
      }

      public String getpName() {
            return pName;
      }
      public void setpName(String pName) {
            this.pName = pName;
      }
      public Integer getMembersId() {
            return membersId;
      }

      public void setMembersId(Integer membersId) {
            this.membersId = membersId;
      }

      public String getMembersName() {
            return membersName;
      }

      public void setMembersName(String membersName) {
            this.membersName = membersName;
      }

}
