package pp.rsmmm.domain.consumer.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pp.rsmmm.domain.budget.entity.Budget;
import pp.rsmmm.domain.expense.entity.Expense;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Authority authority;

    @OneToMany(mappedBy = "consumer")
    private List<Expense> expenseList;

    @OneToMany(mappedBy = "consumer")
    private List<Budget> budgetList;

    @Builder
    public Consumer(String name, String password, String email, Authority authority) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.authority = Authority.ROLE_MEMBER;
    }
}
