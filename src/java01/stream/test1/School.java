package java01.stream.test1;

public class School {
    String citySchoolCode;    //    시도교육청코드
    String citySchoolName;//    시도교육청명
    String schoolCode;//    표준학교코드
    String schoolName;//    학교명
    String schoolNameEng;//    영문학교명
    String schoolCategory;//    학교종류명
    String locationName;//    소재지명
    String jurisdictionOrgName;//    관할조직명
    String establishmentName;//    설립명
    String zipCode;//    도로명우편번호
    String address1;//    도로명주소
    String address2;//    도로명상세주소
    String phone;//    전화번호
    String homepageUrl;//    홈페이지주소
    String division;//    남녀공학구분명
    String fax;//    팩스번호
    String schoolDivision;//    고등학교구분명
    String classificationTf;//    고등학교구분명산업체특별학급존재여부
    String classificationName;//    고등학교일반실업구분명
    String affiliationName;//    특수목적고등학교계열명
    String entrance;//    입시전후기구분명
    String dayAndNightTF;//    주야구분명
    String createdDate;//    설립일자
    String anniversary;//    개교기념일
    String modifiedDate;//    수정일

    public String getCitySchoolCode() {
        return citySchoolCode;
    }

    public void setCitySchoolCode(String citySchoolCode) {
        this.citySchoolCode = citySchoolCode;
    }

    public String getCitySchoolName() {
        return citySchoolName;
    }

    public void setCitySchoolName(String citySchoolName) {
        this.citySchoolName = citySchoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolNameEng() {
        return schoolNameEng;
    }

    public void setSchoolNameEng(String schoolNameEng) {
        this.schoolNameEng = schoolNameEng;
    }

    public String getSchoolCategory() {
        return schoolCategory;
    }

    public void setSchoolCategory(String schoolCategory) {
        this.schoolCategory = schoolCategory;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getJurisdictionOrgName() {
        return jurisdictionOrgName;
    }

    public void setJurisdictionOrgName(String jurisdictionOrgName) {
        this.jurisdictionOrgName = jurisdictionOrgName;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSchoolDivision() {
        return schoolDivision;
    }

    public void setSchoolDivision(String schoolDivision) {
        this.schoolDivision = schoolDivision;
    }

    public String getClassificationTf() {
        return classificationTf;
    }

    public void setClassificationTf(String classificationTf) {
        this.classificationTf = classificationTf;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getDayAndNightTF() {
        return dayAndNightTF;
    }

    public void setDayAndNightTF(String dayAndNightTF) {
        this.dayAndNightTF = dayAndNightTF;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "School{" +
                "citySchoolCode='" + citySchoolCode + '\'' +
                ", citySchoolName='" + citySchoolName + '\'' +
                ", schoolCode='" + schoolCode + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolNameEng='" + schoolNameEng + '\'' +
                ", schoolCategory='" + schoolCategory + '\'' +
                ", locationName='" + locationName + '\'' +
                ", jurisdictionOrgName='" + jurisdictionOrgName + '\'' +
                ", establishmentName='" + establishmentName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", phone='" + phone + '\'' +
                ", homepageUrl='" + homepageUrl + '\'' +
                ", division='" + division + '\'' +
                ", fax='" + fax + '\'' +
                ", schoolDivision='" + schoolDivision + '\'' +
                ", classificationTf='" + classificationTf + '\'' +
                ", classificationName='" + classificationName + '\'' +
                ", affiliationName='" + affiliationName + '\'' +
                ", entrance='" + entrance + '\'' +
                ", dayAndNightTF='" + dayAndNightTF + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", anniversary='" + anniversary + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
