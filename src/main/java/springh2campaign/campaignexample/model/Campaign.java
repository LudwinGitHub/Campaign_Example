package springh2campaign.campaignexample.model;

import javax.persistence.*;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "keywords", nullable = false)
    private String keyWords;
    @Column(name = "bid amount", nullable = false)
    private int bidAmount;
    @Column(name = "campaign fund", nullable = false)
    private int campaignFund;
    @Column(name = "town")
    private String campaignTown;
    @Column(name = "radius", nullable = false)
    private int radius;
    @Column(name = "status", nullable = false)
    private boolean statusOn;

    public Campaign() {
    }

    public Campaign(String name, String keyWords, int bidAmount, int campaignFund,
                    String campaignTown, int radius, boolean statusOn) {
        this.name = name;
        this.keyWords = keyWords;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.campaignTown = campaignTown;
        this.radius = radius;
        this.statusOn = statusOn;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    public int getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(int campaignFund) {
        this.campaignFund = campaignFund;
    }

    public String getCampaignTown() {
        return campaignTown;
    }

    public void setCampaignTown(String campaignTown) {
        this.campaignTown = campaignTown;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isStatusOn() {
        return statusOn;
    }

    public void setStatusOn(boolean statusOn) {
        this.statusOn = statusOn;
    }

    @Override
    public String toString() {
        return
                "ID:" + id +
                ", name: " + name + '\'' +
                ", Keywords: " + keyWords + '\'' +
                ", Bid amount: " + bidAmount +
                ", Campaign fund: " + campaignFund +
                ", Campaign Town: " + campaignTown + '\'' +
                ", Radius: " + radius +
                ", Campaign status: " + statusOn;
    }
}
