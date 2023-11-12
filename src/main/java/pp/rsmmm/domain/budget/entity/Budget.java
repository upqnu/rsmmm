package pp.rsmmm.domain.budget.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pp.rsmmm.domain.consumer.entity.Consumer;
import pp.rsmmm.domain.item.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();
}
