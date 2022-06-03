package springh2campaign.campaignexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springh2campaign.campaignexample.model.Campaign;


public interface CampaignRepository extends JpaRepository<Campaign, Long> {

}
