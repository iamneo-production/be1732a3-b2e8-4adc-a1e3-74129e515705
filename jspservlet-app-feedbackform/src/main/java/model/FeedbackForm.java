package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="feedback")
public class FeedbackForm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="formId")
	protected int formId;
	
	@Column(name="productName")    
	private String productName;
	
	@Column(name="productQuality")
	private String productQuality;
	
	@Column(name="productWarranty")
	private String productWarranty;

    @Column(name="productRating")
	private String productRating;

    public FeedbackForm() {
    }

    public FeedbackForm(int formId, String productName, String productQuality, String productWarranty,
    String productRating) {
        this.formId = formId;
        this.productName = productName;
        this.productQuality = productQuality;
        this.productWarranty = productWarranty;
        this.productRating = productRating;
    }

    public FeedbackForm(String productName, String productQuality, String productWarranty, String productRating) {
        this.productName = productName;
        this.productQuality = productQuality;
        this.productWarranty = productWarranty;
        this.productRating = productRating;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(String productQuality) {
        this.productQuality = productQuality;
    }

    public String getProductWarranty() {
        return productWarranty;
    }

    public void setProductWarranty(String productWarranty) {
        this.productWarranty = productWarranty;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    
}
