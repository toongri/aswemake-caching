package toongri.blog.dbcacheproject.global;

import lombok.Getter;

@Getter
public enum CacheType {
    GRADE(
            "grades",
            60,
            10
    );

    CacheType(String name, int expireAfterWrite, int size) {
        this.name = name;
        this.expireAfterWrite = expireAfterWrite;
        this.size = size;
    }

    private final String name;
    private final int expireAfterWrite;
    private final int size;

}
