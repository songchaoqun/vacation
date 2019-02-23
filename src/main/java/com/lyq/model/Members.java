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
      private String    sitesUserName;
      @Transient
      private String    staffName;
      @Transient
      private Integer    mid;
      @Transient
      private Integer    ids;
      @Transient
      private Integer    uid;
      @Transient
      private String    createDate;
      @Transient
      private String    duetoDate;
      @Transient
      private String    pName;

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

 public String getSitesUserName() {
  return sitesUserName;
 }

 public void setSitesUserName(String sitesUserName) {
  this.sitesUserName = sitesUserName;
 }

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

 public Integer getMid() {
  return mid;
 }

 public void setMid(Integer mid) {
  this.mid = mid;
 }

 public Integer getIds() {
  return ids;
 }

 public void setIds(Integer ids) {
  this.ids = ids;
 }

 public Integer getUid() {
  return uid;
 }

 public void setUid(Integer uid) {
  this.uid = uid;
 }
}
