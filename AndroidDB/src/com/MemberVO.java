package com;

public class MemberVO {
   
   private String member_id;
   private String member_pw;
   private String member_phone;
   private String member_region;
   private int member_point;
   
   
   
   
   
   public MemberVO(String member_id) {
      this.member_id = member_id;
   }


   public MemberVO(String member_id, String member_pw, String member_phone, String member_region) {
      
      this.member_id = member_id;
      this.member_pw = member_pw;
      this.member_phone = member_phone;
      this.member_region = member_region;
   }


   public MemberVO(String member_id, String member_pw) {
      
      this.member_id = member_id;
      this.member_pw = member_pw;
   }


   public MemberVO(String member_id, String member_pw, String member_phone, String member_region, int member_point) {
      this.member_id = member_id;
      this.member_pw = member_pw;
      this.member_phone = member_phone;
      this.member_region = member_region;
      this.member_point = member_point;
   }
   
   
   public String getMember_id() {
      return member_id;
   }
   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }
   public String getMember_pw() {
      return member_pw;
   }
   public void setMember_pw(String member_pw) {
      this.member_pw = member_pw;
   }
   public String getMember_phone() {
      return member_phone;
   }
   public void setMember_phone(String member_phone) {
      this.member_phone = member_phone;
   }
   public String getMember_region() {
      return member_region;
   }
   public void setMember_region(String member_region) {
      this.member_region = member_region;
   }
   public int getMember_point() {
      return member_point;
   }
   public void setMember_point(int member_point) {
      this.member_point = member_point;
   }
   
   
   
   
   

   

}