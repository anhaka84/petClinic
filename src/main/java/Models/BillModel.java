package Models;

import DB.common.DBCommon;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillModel extends DBCommon<BillModel> {

    private int billId;
    private int bookingId;
    private int userId;
    private int prescriptionId;
    private Date billDate;
    private String titleBill;
    private float total;

    public BillModel() {
    }

    public BillModel(int billId, int bookingId, int userId, int prescriptionId, Date billDate, String titleBill, float total) {
        this.billId = billId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.prescriptionId = prescriptionId;
        this.billDate = billDate;
        this.titleBill = titleBill;
        this.total = total;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getTitleBill() {
        return titleBill;
    }

    public void setTitleBill(String titleBill) {
        this.titleBill = titleBill;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BillModel{" + "billId=" + billId
                + ", bookingId=" + bookingId
                + ", userId=" + userId
                + ", prescriptionId=" + prescriptionId
                + ", billDate=" + billDate
                + ", titleBill=" + titleBill
                + ", total=" + total
                + '}';
    }

    @Override
    public BillModel setResultSetValue(BillModel object, ResultSet rs)
            throws SQLException {
        object.setBillId(rs.getInt("bill_id"));
        object.setBookingId(rs.getInt("booking_id"));
        object.setUserId(rs.getInt("user_id"));
        object.setPrescriptionId(rs.getInt("prescription_id"));
        object.setBillDate(rs.getDate("bill_date"));
        object.setTitleBill(rs.getString("title_bill"));
        object.setTotal(rs.getFloat("total"));
        return object;
    }

}
