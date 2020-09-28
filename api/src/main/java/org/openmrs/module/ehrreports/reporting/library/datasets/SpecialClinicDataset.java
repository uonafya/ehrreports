package org.openmrs.module.ehrreports.reporting.library.datasets;

import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.library.indicators.SpecialClinicIndicators;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialClinicDataset extends BaseDataSet {
  @Autowired private SpecialClinicIndicators indicators;
  @Autowired private OutpatientMetadata outpatientMetadata;

  public DataSetDefinition getSpecialClinic() {
    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    dsd.setName("Work load report");
    dsd.addParameters(getParameters());
    dsd.addColumn(
        "ALLN",
        "Total new patients",
        EhrReportUtils.map(
            indicators.getTotalVisits(outpatientMetadata.getNewPatientConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "ALLR",
        "Total revisit patients",
        EhrReportUtils.map(
            indicators.getTotalVisits(outpatientMetadata.getRevisitConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "EYE",
        "Patient who attended EYE clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getEYEClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "ENT",
        "Patient who attended ENT clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getENTClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "ORT",
        "Patient who attended orthopedic clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getOrthopedicClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "POPC",
        "Patient who attended POPC clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getPopsPediatricClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "TBR",
        "Patient who attended TB & Leprosy clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getTbLeprosyClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "CCC",
        "Patient who attended CCC clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getCccClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "PSY",
        "Patient who attended Psychatric clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getPsycthricClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "MOPCDM",
        "Patient who attended Mopcdm clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getMopsDmDiabeticClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "FNA",
        "Patient who attended FNA clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getFnaClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "GOPS",
        "Patient who attended Gops clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getGpcClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "MCH",
        "Patient who attended MCH clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getMchClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "MOPC",
        "Patient who attended MOPC Medical clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getMopcMedicalClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "MOPC1",
        "Patient who attended MOPC clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getMopsClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "PAL",
        "Patient who attended Palative care clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getPallativeClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "SURG",
        "Patient who attended surgical care clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getSurgicalClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "CAS",
        "Patient who attended Chest and skin care clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getChestAndSkinClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "DENTAL",
        "Patient who attended Dental clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(outpatientMetadata.getDentalClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    dsd.addColumn(
        "FP",
        "Patient who attended Family Planning clinic",
        EhrReportUtils.map(
            indicators.getSpecialClinic(
                outpatientMetadata.getFamilyPlanningClinicConcept().getConceptId()),
            "startDate=${startDate},endDate=${endDate}"),
        "");
    return dsd;
  }
}
