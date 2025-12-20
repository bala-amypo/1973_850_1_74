@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{policyId}")
    public ResponseEntity<Claim> createClaim(@PathVariable Long policyId, @RequestBody ClaimDto dto) {
        // Convert DTO to Model
        Claim claim = new Claim();
        claim.setClaimDate(dto.getClaimDate());
        claim.setClaimAmount(dto.getClaimAmount());
        claim.setDescription(dto.getDescription());
        
        return ResponseEntity.ok(claimService.createClaim(policyId, claim));
    }
}