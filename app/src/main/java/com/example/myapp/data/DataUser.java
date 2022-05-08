package com.example.myapp.data;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class DataUser {
    public String API = "http://192.168.1.149:5000/";
    public  String fullNameStatic = "No Name 1234";

    public  String emailStatic;

    public  String passWordStatic;
    public  String phoneStatic = "No Phone";
    public  String byteArrayImageStatic = "";
    public  String dateOfBirthStatic;
    public  String sexStatic;
    public  String cityStatic;
    public  String townshipStatic;
    public  String wardStatic;
    public  String apartmentNumberStatic="";
    public  float moneyStatic;
    public  int accumulatedPointsStatic;
    public  int carepayactive;



    public  boolean carepay = false;
    public  boolean activedoctor = false;
    public  String idcard;
    public  Uri facecheck = null;
    public  Uri paper1 = null;
    public  Uri paper2 = null;


    public  String TransferCarePayPhone;
    public  String TransferCarePayName;
    public  String TransferCarePayContent;
    public  String TransferCarePayAM;
    public  Integer TransferCarePayCHECK = 0;

    public  String TransferBankPhone;
    public  String TransferBankName;
    public  String TransferBankContent;
    public  String TransferBankAM;
    public  Integer TransferBankCHECK = 0;

    public  Integer CheckIsBank = 0;


    public String commentImageFace;
    public String commentTime;
    public String commentDate;
    public String commentFullName;
    public String commentImage;
    public String commentNumberLike;
    public String commentContent;

    public String commentIDPost;
    public String commentIDPeople;


    public Integer k;
    public Integer LIKEORDIS = 0;

    public String Location;

    public String HomeOneNameHospital;




    public String HomeOneNameUser;
    public String HomeOneGenderUser;
    public String HomeOneAgeUser;
    public String HomeOnePhoneUser;
    public String HomeOneAddressUser;

    public String HomeOneSpecHospital;

    public String HomeOneDate;
    public String HomeOneTime ="";
    public String HomeOneType ="";

    public String CheckTestAtHome;

    public String HomeTowAddress="";

    public String ResultXray;

    public String ServiceContent;
    public String ServiceMoney;
    public String ServiceImage;
    public String ServicehName;

    public String Doctorhospital;
    public String Doctorspec;
    public String Doctorchungchi;
    public String Doctorist;
    public String Doctoristrk;
    public String Doctorrole;
    public String Doctoriscall;


    /////// inf benh nhan

    public String Benhnhanaddress;
    public String Benhnhanage;
    public String Benhnhananame;
    public String Benhnhangender;
    public String Benhnhanphone;
    public String BenhnhanTime;
    public String BenhnhanDate;
    public String BenhnhanActive;
    public String BenhnhanIDL;
    public String BenhnhanID;
    public String BenhnhanEX;
    public String BenhnhanThuoc = "";
    public Integer checkHomeP;
    // //name, email, pass, phone, image,dateofb,  gender, address, money, point, carepay;
    public String AllClientname;
    public String AllClientemail;
    public String AllClientpass;
    public String AllClientphone;
    public String AllClientimage;
    public String AllClientdateofb;
    public String AllClientgender;
    public String AllClientaddress;
    public String AllClientmoney;
    public String AllClientpoint;
    public String AllClientcarepayat;

    ///
    public String AllDoctorname;
    public String AllDoctoremail;
    public String AllDoctorpass;
    public String AllDoctorphone;
    public String AllDoctorimage;
    public String AllDoctordateofb;
    public String AllDoctorgender;
    public String AllDoctoraddress;
    public String AllDoctormoney;
    public String AllDoctorpoint;
    public String AllDoctorcarepayat;

    public String AllDoctorhospital;
    public String AllDoctorspec;
    public String AllDoctorcc;
    public String AllDoctorID;

    public String DoctorFree;

    public String DoctorDcchonImage;
    public String DoctorDcchonName;

    public String getAllDoctorID() {
        return AllDoctorID;
    }

    public void setAllDoctorID(String allDoctorID) {
        AllDoctorID = allDoctorID;
    }

    public String getBenhnhanID() {
        return BenhnhanID;
    }

    public void setBenhnhanID(String benhnhanID) {
        BenhnhanID = benhnhanID;
    }

    public String getDoctorDcchonImage() {
        return DoctorDcchonImage;
    }

    public void setDoctorDcchonImage(String doctorDcchonImage) {
        DoctorDcchonImage = doctorDcchonImage;
    }

    public String getDoctorDcchonName() {
        return DoctorDcchonName;
    }

    public void setDoctorDcchonName(String doctorDcchonName) {
        DoctorDcchonName = doctorDcchonName;
    }

    public String getDoctorFree() {
        return DoctorFree;
    }

    public void setDoctorFree(String doctorFree) {
        DoctorFree = doctorFree;
    }

    public String getAllDoctorname() {
        return AllDoctorname;
    }

    public void setAllDoctorname(String allDoctorname) {
        AllDoctorname = allDoctorname;
    }

    public String getAllDoctoremail() {
        return AllDoctoremail;
    }

    public void setAllDoctoremail(String allDoctoremail) {
        AllDoctoremail = allDoctoremail;
    }

    public String getAllDoctorpass() {
        return AllDoctorpass;
    }

    public void setAllDoctorpass(String allDoctorpass) {
        AllDoctorpass = allDoctorpass;
    }

    public String getAllDoctorphone() {
        return AllDoctorphone;
    }

    public void setAllDoctorphone(String allDoctorphone) {
        AllDoctorphone = allDoctorphone;
    }

    public String getAllDoctorimage() {
        return AllDoctorimage;
    }

    public void setAllDoctorimage(String allDoctorimage) {
        AllDoctorimage = allDoctorimage;
    }

    public String getAllDoctordateofb() {
        return AllDoctordateofb;
    }

    public void setAllDoctordateofb(String allDoctordateofb) {
        AllDoctordateofb = allDoctordateofb;
    }

    public String getAllDoctorgender() {
        return AllDoctorgender;
    }

    public void setAllDoctorgender(String allDoctorgender) {
        AllDoctorgender = allDoctorgender;
    }

    public String getAllDoctoraddress() {
        return AllDoctoraddress;
    }

    public void setAllDoctoraddress(String allDoctoraddress) {
        AllDoctoraddress = allDoctoraddress;
    }

    public String getAllDoctormoney() {
        return AllDoctormoney;
    }

    public void setAllDoctormoney(String allDoctormoney) {
        AllDoctormoney = allDoctormoney;
    }

    public String getAllDoctorpoint() {
        return AllDoctorpoint;
    }

    public void setAllDoctorpoint(String allDoctorpoint) {
        AllDoctorpoint = allDoctorpoint;
    }

    public String getAllDoctorcarepayat() {
        return AllDoctorcarepayat;
    }

    public void setAllDoctorcarepayat(String allDoctorcarepayat) {
        AllDoctorcarepayat = allDoctorcarepayat;
    }

    public String getAllDoctorhospital() {
        return AllDoctorhospital;
    }

    public void setAllDoctorhospital(String allDoctorhospital) {
        AllDoctorhospital = allDoctorhospital;
    }

    public String getAllDoctorspec() {
        return AllDoctorspec;
    }

    public void setAllDoctorspec(String allDoctorspec) {
        AllDoctorspec = allDoctorspec;
    }

    public String getAllDoctorcc() {
        return AllDoctorcc;
    }

    public void setAllDoctorcc(String allDoctorcc) {
        AllDoctorcc = allDoctorcc;
    }

    public String getAllClientname() {
        return AllClientname;
    }

    public void setAllClientname(String allClientname) {
        AllClientname = allClientname;
    }

    public String getAllClientemail() {
        return AllClientemail;
    }

    public void setAllClientemail(String allClientemail) {
        AllClientemail = allClientemail;
    }

    public String getAllClientpass() {
        return AllClientpass;
    }

    public void setAllClientpass(String allClientpass) {
        AllClientpass = allClientpass;
    }

    public String getAllClientphone() {
        return AllClientphone;
    }

    public void setAllClientphone(String allClientphone) {
        AllClientphone = allClientphone;
    }

    public String getAllClientimage() {
        return AllClientimage;
    }

    public void setAllClientimage(String allClientimage) {
        AllClientimage = allClientimage;
    }

    public String getAllClientdateofb() {
        return AllClientdateofb;
    }

    public void setAllClientdateofb(String allClientdateofb) {
        AllClientdateofb = allClientdateofb;
    }

    public String getAllClientgender() {
        return AllClientgender;
    }

    public void setAllClientgender(String allClientgender) {
        AllClientgender = allClientgender;
    }

    public String getAllClientaddress() {
        return AllClientaddress;
    }

    public void setAllClientaddress(String allClientaddress) {
        AllClientaddress = allClientaddress;
    }

    public String getAllClientmoney() {
        return AllClientmoney;
    }

    public void setAllClientmoney(String allClientmoney) {
        AllClientmoney = allClientmoney;
    }

    public String getAllClientpoint() {
        return AllClientpoint;
    }

    public void setAllClientpoint(String allClientpoint) {
        AllClientpoint = allClientpoint;
    }

    public String getAllClientcarepayat() {
        return AllClientcarepayat;
    }

    public void setAllClientcarepayat(String allClientcarepayat) {
        AllClientcarepayat = allClientcarepayat;
    }

    public String getDoctoriscall() {
        return Doctoriscall;
    }

    public void setDoctoriscall(String doctoriscall) {
        Doctoriscall = doctoriscall;
    }

    public String getBenhnhanEX() {
        return BenhnhanEX;
    }

    public void setBenhnhanEX(String benhnhanEX) {
        BenhnhanEX = benhnhanEX;
    }

    public String getBenhnhanThuoc() {
        return BenhnhanThuoc;
    }

    public void setBenhnhanThuoc(String benhnhanThuoc) {
        BenhnhanThuoc = benhnhanThuoc;
    }

    //    public List<ItemNewDataSpecservice> listSPECSERVICE1 = new ArrayList<>();
//
//    public List<ItemNewDataSpecservice> getListSPECSERVICE1() {
//        return listSPECSERVICE1;
//    }
//
//    public void setListSPECSERVICE1(List<ItemNewDataSpecservice> listSPECSERVICE1) {
//        this.listSPECSERVICE1 = listSPECSERVICE1;
//    }

    public Integer getCheckHomeP() {
        return checkHomeP;
    }

    public void setCheckHomeP(Integer checkHomeP) {
        this.checkHomeP = checkHomeP;
    }

    public String getBenhnhanIDL() {
        return BenhnhanIDL;
    }

    public void setBenhnhanIDL(String benhnhanIDL) {
        BenhnhanIDL = benhnhanIDL;
    }



    public String getBenhnhanActive() {
        return BenhnhanActive;
    }

    public void setBenhnhanActive(String benhnhanActive) {
        BenhnhanActive = benhnhanActive;
    }

    public String getBenhnhanTime() {
        return BenhnhanTime;
    }

    public void setBenhnhanTime(String benhnhanTime) {
        BenhnhanTime = benhnhanTime;
    }

    public String getBenhnhanDate() {
        return BenhnhanDate;
    }

    public void setBenhnhanDate(String benhnhanDate) {
        BenhnhanDate = benhnhanDate;
    }

    public String getBenhnhanaddress() {
        return Benhnhanaddress;
    }

    public void setBenhnhanaddress(String benhnhanaddress) {
        Benhnhanaddress = benhnhanaddress;
    }

    public String getBenhnhanage() {
        return Benhnhanage;
    }

    public void setBenhnhanage(String benhnhanage) {
        Benhnhanage = benhnhanage;
    }

    public String getBenhnhananame() {
        return Benhnhananame;
    }

    public void setBenhnhananame(String benhnhananame) {
        Benhnhananame = benhnhananame;
    }

    public String getBenhnhangender() {
        return Benhnhangender;
    }

    public void setBenhnhangender(String benhnhangender) {
        Benhnhangender = benhnhangender;
    }

    public String getBenhnhanphone() {
        return Benhnhanphone;
    }

    public void setBenhnhanphone(String benhnhanphone) {
        Benhnhanphone = benhnhanphone;
    }

    public String getDoctorrole() {
        return Doctorrole;
    }

    public void setDoctorrole(String doctorrole) {
        Doctorrole = doctorrole;
    }

    public String getDoctorchungchi() {
        return Doctorchungchi;
    }

    public void setDoctorchungchi(String doctorchungchi) {
        Doctorchungchi = doctorchungchi;
    }

    public String getDoctorist() {
        return Doctorist;
    }

    public void setDoctorist(String doctorist) {
        Doctorist = doctorist;
    }

    public String getDoctoristrk() {
        return Doctoristrk;
    }

    public void setDoctoristrk(String doctoristrk) {
        Doctoristrk = doctoristrk;
    }

    public String getDoctorhospital() {
        return Doctorhospital;
    }

    public void setDoctorhospital(String doctorhospital) {
        Doctorhospital = doctorhospital;
    }

    public String getDoctorspec() {
        return Doctorspec;
    }

    public void setDoctorspec(String doctorspec) {
        Doctorspec = doctorspec;
    }

    public  boolean carepaytoface = false;
    public  boolean activedoctortoface = false;

    public boolean isCarepaytoface() {
        return carepaytoface;
    }

    public void setCarepaytoface(boolean carepaytoface) {
        this.carepaytoface = carepaytoface;
    }

    public boolean isActivedoctortoface() {
        return activedoctortoface;
    }

    public void setActivedoctortoface(boolean activedoctortoface) {
        this.activedoctortoface = activedoctortoface;
    }

    public boolean isActivedoctor() {
        return activedoctor;
    }

    public void setActivedoctor(boolean activedoctor) {
        this.activedoctor = activedoctor;
    }

    public String getServiceContent() {
        return ServiceContent;
    }

    public void setServiceContent(String serviceContent) {
        ServiceContent = serviceContent;
    }

    public String getServiceMoney() {
        return ServiceMoney;
    }

    public void setServiceMoney(String serviceMoney) {
        ServiceMoney = serviceMoney;
    }

    public String getServiceImage() {
        return ServiceImage;
    }

    public void setServiceImage(String serviceImage) {
        ServiceImage = serviceImage;
    }

    public String getServicehName() {
        return ServicehName;
    }

    public void setServicehName(String servicehName) {
        ServicehName = servicehName;
    }

    public String getResultXray() {
        return ResultXray;
    }

    public void setResultXray(String resultXray) {
        ResultXray = resultXray;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getHomeTowAddress() {
        return HomeTowAddress;
    }

    public void setHomeTowAddress(String homeTowAddress) {
        HomeTowAddress = homeTowAddress;
    }

    public String getCheckTestAtHome() {
        return CheckTestAtHome;
    }



    public void setCheckTestAtHome(String checkTestAtHome) {
        CheckTestAtHome = checkTestAtHome;
    }

    public String getHomeOneDate() {
        return HomeOneDate;
    }

    public void setHomeOneDate(String homeOneDate) {
        HomeOneDate = homeOneDate;
    }

    public String getHomeOneTime() {
        return HomeOneTime;
    }

    public void setHomeOneTime(String homeOneTime) {
        HomeOneTime = homeOneTime;
    }

    public String getHomeOneType() {
        return HomeOneType;
    }

    public void setHomeOneType(String homeOneType) {
        HomeOneType = homeOneType;
    }

    public String getHomeOneSpecHospital() {
        return HomeOneSpecHospital;
    }

    public void setHomeOneSpecHospital(String homeOneSpecHospital) {
        HomeOneSpecHospital = homeOneSpecHospital;
    }

    public String getHomeOneNameUser() {
        return HomeOneNameUser;
    }

    public void setHomeOneNameUser(String homeOneNameUser) {
        HomeOneNameUser = homeOneNameUser;
    }

    public String getHomeOneGenderUser() {
        return HomeOneGenderUser;
    }

    public void setHomeOneGenderUser(String homeOneGenderUser) {
        HomeOneGenderUser = homeOneGenderUser;
    }

    public String getHomeOneAgeUser() {
        return HomeOneAgeUser;
    }

    public void setHomeOneAgeUser(String homeOneAgeUser) {
        HomeOneAgeUser = homeOneAgeUser;
    }

    public String getHomeOnePhoneUser() {
        return HomeOnePhoneUser;
    }

    public void setHomeOnePhoneUser(String homeOnePhoneUser) {
        HomeOnePhoneUser = homeOnePhoneUser;
    }

    public String getHomeOneAddressUser() {
        return HomeOneAddressUser;
    }

    public void setHomeOneAddressUser(String homeOneAddressUser) {
        HomeOneAddressUser = homeOneAddressUser;
    }

    public String getHomeOneNameHospital() {
        return HomeOneNameHospital;
    }

    public void setHomeOneNameHospital(String homeOneNameHospital) {
        HomeOneNameHospital = homeOneNameHospital;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Integer getLIKEORDIS() {
        return LIKEORDIS;
    }

    public void setLIKEORDIS(Integer LIKEORDIS) {
        this.LIKEORDIS = LIKEORDIS;
    }

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }



    public String getCommentImageFace() {
        return commentImageFace;
    }

    public void setCommentImageFace(String commentImageFace) {
        this.commentImageFace = commentImageFace;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentFullName() {
        return commentFullName;
    }

    public void setCommentFullName(String commentFullName) {
        this.commentFullName = commentFullName;
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    public String getCommentNumberLike() {
        return commentNumberLike;
    }

    public void setCommentNumberLike(String commentNumberLike) {
        this.commentNumberLike = commentNumberLike;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getFullNameStatic() {
        return fullNameStatic;
    }

    public void setFullNameStatic(String fullNameStatic) {
        this.fullNameStatic = fullNameStatic;
    }

    public String getEmailStatic() {
        return emailStatic;
    }

    public void setEmailStatic(String emailStatic) {
        this.emailStatic = emailStatic;
    }

    public String getPassWordStatic() {
        return passWordStatic;
    }

    public void setPassWordStatic(String passWordStatic) {
        this.passWordStatic = passWordStatic;
    }

    public String getPhoneStatic() {
        return phoneStatic;
    }

    public void setPhoneStatic(String phoneStatic) {
        this.phoneStatic = phoneStatic;
    }

    public String getByteArrayImageStatic() {
        return byteArrayImageStatic;
    }

    public void setByteArrayImageStatic(String byteArrayImageStatic) {
        this.byteArrayImageStatic = byteArrayImageStatic;
    }

    public String getDateOfBirthStatic() {
        return dateOfBirthStatic;
    }

    public void setDateOfBirthStatic(String dateOfBirthStatic) {
        this.dateOfBirthStatic = dateOfBirthStatic;
    }

    public String getSexStatic() {
        return sexStatic;
    }

    public void setSexStatic(String sexStatic) {
        this.sexStatic = sexStatic;
    }

    public String getCityStatic() {
        return cityStatic;
    }

    public void setCityStatic(String cityStatic) {
        this.cityStatic = cityStatic;
    }

    public String getTownshipStatic() {
        return townshipStatic;
    }

    public void setTownshipStatic(String townshipStatic) {
        this.townshipStatic = townshipStatic;
    }

    public String getWardStatic() {
        return wardStatic;
    }

    public void setWardStatic(String wardStatic) {
        this.wardStatic = wardStatic;
    }

    public String getApartmentNumberStatic() {
        return apartmentNumberStatic;
    }

    public void setApartmentNumberStatic(String apartmentNumberStatic) {
        this.apartmentNumberStatic = apartmentNumberStatic;
    }

    public float getMoneyStatic() {
        return moneyStatic;
    }

    public void setMoneyStatic(float moneyStatic) {
        this.moneyStatic = moneyStatic;
    }

    public int getAccumulatedPointsStatic() {
        return accumulatedPointsStatic;
    }

    public void setAccumulatedPointsStatic(int accumulatedPointsStatic) {
        this.accumulatedPointsStatic = accumulatedPointsStatic;
    }

    public int getCarepayactive() {
        return carepayactive;
    }

    public void setCarepayactive(int carepayactive) {
        this.carepayactive = carepayactive;
    }

    public boolean isCarepay() {
        return carepay;
    }

    public void setCarepay(boolean carepay) {
        this.carepay = carepay;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Uri getFacecheck() {
        return facecheck;
    }

    public void setFacecheck(Uri facecheck) {
        this.facecheck = facecheck;
    }

    public Uri getPaper1() {
        return paper1;
    }

    public void setPaper1(Uri paper1) {
        this.paper1 = paper1;
    }

    public Uri getPaper2() {
        return paper2;
    }

    public void setPaper2(Uri paper2) {
        this.paper2 = paper2;
    }

    public String getTransferCarePayPhone() {
        return TransferCarePayPhone;
    }

    public void setTransferCarePayPhone(String transferCarePayPhone) {
        TransferCarePayPhone = transferCarePayPhone;
    }

    public String getTransferCarePayName() {
        return TransferCarePayName;
    }

    public void setTransferCarePayName(String transferCarePayName) {
        TransferCarePayName = transferCarePayName;
    }

    public String getTransferCarePayContent() {
        return TransferCarePayContent;
    }

    public void setTransferCarePayContent(String transferCarePayContent) {
        TransferCarePayContent = transferCarePayContent;
    }

    public String getTransferCarePayAM() {
        return TransferCarePayAM;
    }

    public void setTransferCarePayAM(String transferCarePayAM) {
        TransferCarePayAM = transferCarePayAM;
    }

    public Integer getTransferCarePayCHECK() {
        return TransferCarePayCHECK;
    }

    public void setTransferCarePayCHECK(Integer transferCarePayCHECK) {
        TransferCarePayCHECK = transferCarePayCHECK;
    }

    public String getTransferBankPhone() {
        return TransferBankPhone;
    }

    public void setTransferBankPhone(String transferBankPhone) {
        TransferBankPhone = transferBankPhone;
    }

    public String getTransferBankName() {
        return TransferBankName;
    }

    public void setTransferBankName(String transferBankName) {
        TransferBankName = transferBankName;
    }

    public String getTransferBankContent() {
        return TransferBankContent;
    }

    public void setTransferBankContent(String transferBankContent) {
        TransferBankContent = transferBankContent;
    }

    public String getTransferBankAM() {
        return TransferBankAM;
    }

    public void setTransferBankAM(String transferBankAM) {
        TransferBankAM = transferBankAM;
    }

    public Integer getTransferBankCHECK() {
        return TransferBankCHECK;
    }

    public void setTransferBankCHECK(Integer transferBankCHECK) {
        TransferBankCHECK = transferBankCHECK;
    }

    public  Integer getCheckIsBank() {
        return CheckIsBank;
    }

    public  void setCheckIsBank(Integer checkIsBank) {
        CheckIsBank = checkIsBank;
    }

    public String getCommentIDPost() {
        return commentIDPost;
    }

    public void setCommentIDPost(String commentIDPost) {
        this.commentIDPost = commentIDPost;
    }

    public String getCommentIDPeople() {
        return commentIDPeople;
    }

    public void setCommentIDPeople(String commentIDPeople) {
        this.commentIDPeople = commentIDPeople;
    }
}
