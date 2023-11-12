package pp.rsmmm.domain.item.entity;

public enum Category {

    INCOME("수입"),
    GROCERY("식료품비"),
    MEDICAL("의료비"),
    HOUSING("주거비"),
    CLOTHING("의류비"),
    EDUCATION("교육비"),
    LEISURE("여가비"),
    INVEST("투자&저축"),
    RESERVE("예비비");

    private final String category;

    Category(String category) {
        this.category = category;
    }
}
