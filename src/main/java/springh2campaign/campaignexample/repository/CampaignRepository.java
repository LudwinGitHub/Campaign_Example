package springh2campaign.campaignexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springh2campaign.campaignexample.model.Campaign;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    @Override
    List<Campaign> findAll();
}
