package springh2campaign.campaignexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springh2campaign.campaignexample.exeption.ResourceNotFoundException;
import springh2campaign.campaignexample.model.Campaign;
import springh2campaign.campaignexample.repository.CampaignRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;

    @GetMapping("/campaigns")
    public List<Campaign> findAllCampaigns(){
       return campaignRepository.findAll();
    }
   /**
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign){
        try {
            Campaign _campaign = campaignRepository
                    .save(new Campaign(campaign.getName(), campaign.getKeyWords(), campaign.getBidAmount(),
                            campaign.getCampaignFund(), campaign.getCampaignTown(), campaign.getRadius(),
                            campaign.isStatusOn()));
            return new ResponseEntity<>(_campaign, HttpStatus.CREATED);
        } catch (Exception e ){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
   @PostMapping("/campaigns/create")
    public Campaign createCampaign(@Validated @RequestBody Campaign campaign){
        return campaignRepository.save(campaign);
    }

    @PutMapping("/campaigns/update?{id}")
    public ResponseEntity<Campaign> updateCampaign
            (@PathVariable(value = "id") Long campaignId,@Validated @RequestBody Campaign campaignInfo) throws ResourceNotFoundException {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found"));

        campaign.setName(campaignInfo.getName());
        campaign.setKeyWords(campaignInfo.getKeyWords());
        campaign.setCampaignFund(campaignInfo.getCampaignFund());
        campaign.setCampaignTown(campaignInfo.getCampaignTown());
        campaign.setBidAmount(campaignInfo.getBidAmount());
        campaign.setRadius(campaignInfo.getRadius());
        campaign.setStatusOn(campaignInfo.isStatusOn());
        final Campaign updatedCampaign = campaignRepository.save(campaign);
        return ResponseEntity.ok(updatedCampaign);
    }

    @DeleteMapping("/campaigns/delete?{id}")
    public Map<String, Boolean> deleteCampaign(@PathVariable(value = "id") Long campaignId) throws ResourceNotFoundException {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(()->new ResourceNotFoundException("Campaign not found"));
        campaignRepository.delete(campaign);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
