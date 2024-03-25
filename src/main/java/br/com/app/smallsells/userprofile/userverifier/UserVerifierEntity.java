package br.com.app.smallsells.userprofile.userverifier;

import br.com.app.smallsells.user.UserEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserVerifierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private Instant expirationDate;

    @ManyToOne
    @JoinColumn(name = "USER", referencedColumnName = "ID", unique = true)
    private UserEntity user;
}
