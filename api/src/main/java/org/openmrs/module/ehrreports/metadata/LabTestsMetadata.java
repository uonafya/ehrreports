package org.openmrs.module.ehrreports.metadata;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabTestsMetadata extends Metadata {
  @Autowired OutpatientMetadata outpatientMetadata;

  /**
   * Get all lab tests concepts as a list
   *
   * @return List<Interger></Interger>
   */
  public List<Integer> getTyphoidTestConceptList() {
    return Arrays.asList(
        outpatientMetadata
            .getTyphoidFeverConcept()
            .getConceptId()); // replace this with a typhoidTestConceptId
  }
}
