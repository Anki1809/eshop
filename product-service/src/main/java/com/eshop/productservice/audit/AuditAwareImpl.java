package com.eshop.productservice.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    private final ThreadLocal<String> currentAuditor = new ThreadLocal<>();

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(currentAuditor.get());
    }

    public void setCurrentAuditor(String auditor) {
        currentAuditor.set(auditor);
    }

    public void clear() {
        currentAuditor.remove(); // Clear the auditor after usage, if necessary
    }
}
