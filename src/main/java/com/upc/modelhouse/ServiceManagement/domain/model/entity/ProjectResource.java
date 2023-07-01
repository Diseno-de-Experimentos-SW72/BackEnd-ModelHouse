    package com.upc.modelhouse.ServiceManagement.domain.model.entity;

    import lombok.*;

    import javax.persistence.*;

    @Getter
    @Setter
    @With
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class ProjectResource {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String description;
        private Number quantity;
        private String state;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "proposal_id", nullable = false)
        private Proposal proposal;
    }
