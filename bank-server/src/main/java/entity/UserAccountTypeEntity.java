package entity;

import javax.persistence.*;

@Entity
@Table(name = "user_account_type", schema = "bank_manage", catalog = "")
public class UserAccountTypeEntity {
    private Long id;
    private String name;
    private String description;
    private Integer minimumAge;
    private Integer maximumAge;
    private Integer cardType;
    private Integer physicalCard;
    private Integer studentInfoRequire;
    private Double chargeSelfserviceTrans;
    private Double chargeAtmDepositWithdraw;
    private Integer chargePerQuarter;
    private Double chargePerQuarterMinimumBalance;
    private Double chargePerQuarterAmount;
    private Double chargePerYear;
    private Double chargeCardIssue;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Basic
    @Column(name = "maximum_age", nullable = false)
    public Integer getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(Integer maximumAge) {
        this.maximumAge = maximumAge;
    }

    @Basic
    @Column(name = "card_type", nullable = false)
    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "physical_card", nullable = false)
    public Integer getPhysicalCard() {
        return physicalCard;
    }

    public void setPhysicalCard(Integer physicalCard) {
        this.physicalCard = physicalCard;
    }

    @Basic
    @Column(name = "student_info_require", nullable = false)
    public Integer getStudentInfoRequire() {
        return studentInfoRequire;
    }

    public void setStudentInfoRequire(Integer studentInfoRequire) {
        this.studentInfoRequire = studentInfoRequire;
    }

    @Basic
    @Column(name = "charge_selfservice_trans", nullable = false, precision = 0)
    public Double getChargeSelfserviceTrans() {
        return chargeSelfserviceTrans;
    }

    public void setChargeSelfserviceTrans(Double chargeSelfserviceTrans) {
        this.chargeSelfserviceTrans = chargeSelfserviceTrans;
    }

    @Basic
    @Column(name = "charge_atm_deposit_withdraw", nullable = false, precision = 0)
    public Double getChargeAtmDepositWithdraw() {
        return chargeAtmDepositWithdraw;
    }

    public void setChargeAtmDepositWithdraw(Double chargeAtmDepositWithdraw) {
        this.chargeAtmDepositWithdraw = chargeAtmDepositWithdraw;
    }

    @Basic
    @Column(name = "charge_per_quarter", nullable = false)
    public Integer getChargePerQuarter() {
        return chargePerQuarter;
    }

    public void setChargePerQuarter(Integer chargePerQuarter) {
        this.chargePerQuarter = chargePerQuarter;
    }

    @Basic
    @Column(name = "charge_per_quarter_minimum_balance", nullable = false, precision = 0)
    public Double getChargePerQuarterMinimumBalance() {
        return chargePerQuarterMinimumBalance;
    }

    public void setChargePerQuarterMinimumBalance(Double chargePerQuarterMinimumBalance) {
        this.chargePerQuarterMinimumBalance = chargePerQuarterMinimumBalance;
    }

    @Basic
    @Column(name = "charge_per_quarter_amount", nullable = false, precision = 0)
    public Double getChargePerQuarterAmount() {
        return chargePerQuarterAmount;
    }

    public void setChargePerQuarterAmount(Double chargePerQuarterAmount) {
        this.chargePerQuarterAmount = chargePerQuarterAmount;
    }

    @Basic
    @Column(name = "charge_per_year", nullable = false, precision = 0)
    public Double getChargePerYear() {
        return chargePerYear;
    }

    public void setChargePerYear(Double chargePerYear) {
        this.chargePerYear = chargePerYear;
    }

    @Basic
    @Column(name = "charge_card_issue", nullable = false, precision = 0)
    public Double getChargeCardIssue() {
        return chargeCardIssue;
    }

    public void setChargeCardIssue(Double chargeCardIssue) {
        this.chargeCardIssue = chargeCardIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccountTypeEntity that = (UserAccountTypeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (minimumAge != null ? !minimumAge.equals(that.minimumAge) : that.minimumAge != null) return false;
        if (maximumAge != null ? !maximumAge.equals(that.maximumAge) : that.maximumAge != null) return false;
        if (cardType != null ? !cardType.equals(that.cardType) : that.cardType != null) return false;
        if (physicalCard != null ? !physicalCard.equals(that.physicalCard) : that.physicalCard != null) return false;
        if (studentInfoRequire != null ? !studentInfoRequire.equals(that.studentInfoRequire) : that.studentInfoRequire != null)
            return false;
        if (chargeSelfserviceTrans != null ? !chargeSelfserviceTrans.equals(that.chargeSelfserviceTrans) : that.chargeSelfserviceTrans != null)
            return false;
        if (chargeAtmDepositWithdraw != null ? !chargeAtmDepositWithdraw.equals(that.chargeAtmDepositWithdraw) : that.chargeAtmDepositWithdraw != null)
            return false;
        if (chargePerQuarter != null ? !chargePerQuarter.equals(that.chargePerQuarter) : that.chargePerQuarter != null)
            return false;
        if (chargePerQuarterMinimumBalance != null ? !chargePerQuarterMinimumBalance.equals(that.chargePerQuarterMinimumBalance) : that.chargePerQuarterMinimumBalance != null)
            return false;
        if (chargePerQuarterAmount != null ? !chargePerQuarterAmount.equals(that.chargePerQuarterAmount) : that.chargePerQuarterAmount != null)
            return false;
        if (chargePerYear != null ? !chargePerYear.equals(that.chargePerYear) : that.chargePerYear != null)
            return false;
        return chargeCardIssue != null ? chargeCardIssue.equals(that.chargeCardIssue) : that.chargeCardIssue == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (minimumAge != null ? minimumAge.hashCode() : 0);
        result = 31 * result + (maximumAge != null ? maximumAge.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + (physicalCard != null ? physicalCard.hashCode() : 0);
        result = 31 * result + (studentInfoRequire != null ? studentInfoRequire.hashCode() : 0);
        result = 31 * result + (chargeSelfserviceTrans != null ? chargeSelfserviceTrans.hashCode() : 0);
        result = 31 * result + (chargeAtmDepositWithdraw != null ? chargeAtmDepositWithdraw.hashCode() : 0);
        result = 31 * result + (chargePerQuarter != null ? chargePerQuarter.hashCode() : 0);
        result = 31 * result + (chargePerQuarterMinimumBalance != null ? chargePerQuarterMinimumBalance.hashCode() : 0);
        result = 31 * result + (chargePerQuarterAmount != null ? chargePerQuarterAmount.hashCode() : 0);
        result = 31 * result + (chargePerYear != null ? chargePerYear.hashCode() : 0);
        result = 31 * result + (chargeCardIssue != null ? chargeCardIssue.hashCode() : 0);
        return result;
    }
}
