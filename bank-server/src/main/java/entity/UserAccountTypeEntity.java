package entity;

import javax.persistence.*;

@Entity
@Table(name = "user_account_type", schema = "bank_manage", catalog = "")
public class UserAccountTypeEntity {
    private long id;
    private String name;
    private String description;
    private int minimumAge;
    private int maximumAge;
    private int cardType;
    private int physicalCard;
    private int studentInfoRequire;
    private double chargeSelfserviceTrans;
    private double chargeAtmDepositWithdraw;
    private int chargePerQuarter;
    private double chargePerQuarterMinimumBanlance;
    private double chargePerQuarterAmount;
    private double chargePerYear;
    private double chargeCardIssue;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "minimum_age", nullable = false)
    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Basic
    @Column(name = "maximum_age", nullable = false)
    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    @Basic
    @Column(name = "card_type", nullable = false)
    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "physical_card", nullable = false)
    public int getPhysicalCard() {
        return physicalCard;
    }

    public void setPhysicalCard(int physicalCard) {
        this.physicalCard = physicalCard;
    }

    @Basic
    @Column(name = "student_info_require", nullable = false)
    public int getStudentInfoRequire() {
        return studentInfoRequire;
    }

    public void setStudentInfoRequire(int studentInfoRequire) {
        this.studentInfoRequire = studentInfoRequire;
    }

    @Basic
    @Column(name = "charge_selfservice_trans", nullable = false, precision = 0)
    public double getChargeSelfserviceTrans() {
        return chargeSelfserviceTrans;
    }

    public void setChargeSelfserviceTrans(double chargeSelfserviceTrans) {
        this.chargeSelfserviceTrans = chargeSelfserviceTrans;
    }

    @Basic
    @Column(name = "charge_atm_deposit_withdraw", nullable = false, precision = 0)
    public double getChargeAtmDepositWithdraw() {
        return chargeAtmDepositWithdraw;
    }

    public void setChargeAtmDepositWithdraw(double chargeAtmDepositWithdraw) {
        this.chargeAtmDepositWithdraw = chargeAtmDepositWithdraw;
    }

    @Basic
    @Column(name = "charge_per_quarter", nullable = false)
    public int getChargePerQuarter() {
        return chargePerQuarter;
    }

    public void setChargePerQuarter(int chargePerQuarter) {
        this.chargePerQuarter = chargePerQuarter;
    }

    @Basic
    @Column(name = "charge_per_quarter_minimum_banlance", nullable = false, precision = 0)
    public double getChargePerQuarterMinimumBanlance() {
        return chargePerQuarterMinimumBanlance;
    }

    public void setChargePerQuarterMinimumBanlance(double chargePerQuarterMinimumBanlance) {
        this.chargePerQuarterMinimumBanlance = chargePerQuarterMinimumBanlance;
    }

    @Basic
    @Column(name = "charge_per_quarter_amount", nullable = false, precision = 0)
    public double getChargePerQuarterAmount() {
        return chargePerQuarterAmount;
    }

    public void setChargePerQuarterAmount(double chargePerQuarterAmount) {
        this.chargePerQuarterAmount = chargePerQuarterAmount;
    }

    @Basic
    @Column(name = "charge_per_year", nullable = false, precision = 0)
    public double getChargePerYear() {
        return chargePerYear;
    }

    public void setChargePerYear(double chargePerYear) {
        this.chargePerYear = chargePerYear;
    }

    @Basic
    @Column(name = "charge_card_issue", nullable = false, precision = 0)
    public double getChargeCardIssue() {
        return chargeCardIssue;
    }

    public void setChargeCardIssue(double chargeCardIssue) {
        this.chargeCardIssue = chargeCardIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccountTypeEntity that = (UserAccountTypeEntity) o;

        if (id != that.id) return false;
        if (minimumAge != that.minimumAge) return false;
        if (maximumAge != that.maximumAge) return false;
        if (cardType != that.cardType) return false;
        if (physicalCard != that.physicalCard) return false;
        if (studentInfoRequire != that.studentInfoRequire) return false;
        if (Double.compare(that.chargeSelfserviceTrans, chargeSelfserviceTrans) != 0) return false;
        if (Double.compare(that.chargeAtmDepositWithdraw, chargeAtmDepositWithdraw) != 0) return false;
        if (chargePerQuarter != that.chargePerQuarter) return false;
        if (Double.compare(that.chargePerQuarterMinimumBanlance, chargePerQuarterMinimumBanlance) != 0) return false;
        if (Double.compare(that.chargePerQuarterAmount, chargePerQuarterAmount) != 0) return false;
        if (Double.compare(that.chargePerYear, chargePerYear) != 0) return false;
        if (Double.compare(that.chargeCardIssue, chargeCardIssue) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + minimumAge;
        result = 31 * result + maximumAge;
        result = 31 * result + cardType;
        result = 31 * result + physicalCard;
        result = 31 * result + studentInfoRequire;
        temp = Double.doubleToLongBits(chargeSelfserviceTrans);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(chargeAtmDepositWithdraw);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + chargePerQuarter;
        temp = Double.doubleToLongBits(chargePerQuarterMinimumBanlance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(chargePerQuarterAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(chargePerYear);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(chargeCardIssue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
