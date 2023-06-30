package toongri.blog.dbcacheproject.point.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {

    ORDERED,
    PAYED,
    RECEIVED,
    REFUNDED,
    CANCELED;

}
