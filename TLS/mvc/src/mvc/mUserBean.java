package mvc;

public class mUserBean {
    private static String mUserID = "";
    private static String mUserType = "";
    private static String mEmail = "";
    private static String mPassword = "";
    private static String mFirstName = "";
    private static String mLastName = "";
    private static String mGender = "";
    private static String mDOB = "";
    private static String mAddress = "";
    private static String mDelAddress = "";
    private static String mPhoneNo = "";
    private static String errorMsg = "";
    
    // setters
    public void setUserID(String cUserID) {
        mUserID = cUserID;
    }
    
    public void setUserType(String cUserType) {
        mUserType = cUserType;
    }
    
    public void setEmail(String cEmail) {
        mEmail = cEmail;
    }
    
    public void setPassword(String cPassword) {
        mPassword = cPassword;
    }
    
    public void setFirstName(String cFirstName) {
        mFirstName = cFirstName;
    }
    
    public void setLastName(String cLastName) {
        mLastName = cLastName;
    }
    
    public void setGender(String cGender) {
        mGender = cGender;
    }
    
    public void setDOB(String cDOB) {
        mDOB = cDOB;
    }
    
    public void setAddress(String cAddress) {
        mAddress = cAddress;
    }

    public void setDelAddress(String cDelAddress) {
        mDelAddress = cDelAddress;
    }
         
    public void setPhoneNo(String cPhoneNo) {
        mPhoneNo = cPhoneNo;
    }
    
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    // getters
    public String getUserID() {
        return mUserID;
    }
    
    public String getUserType() {
        return mUserType;
    }
    
    public String getEmail() {
        return mEmail;
    }
    
    public String getPassword() {
        return mPassword;
    }
    
    public String getFirstName() {
        return mFirstName;
    }
    
    public String getLastName() {
        return mLastName;
    }
    
    public String getGender() {
        return mGender;
    }
    
    public String getDOB() {
        return mDOB;
    }
    
    public String getAddress() {
        return mAddress;
    }
    
    public String getDelAddress() {
        return mDelAddress;
    }
    
    public String getPhoneNo() {
        return mPhoneNo;
    }
    
    public String getErrorMsg() {
        return errorMsg;
    }
    
    public mUserBean() {
    }
}