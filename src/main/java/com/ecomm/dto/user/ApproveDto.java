package com.ecomm.dto.user;

public class ApproveDto {

    private Long id;

    private boolean approve;

    public ApproveDto() {
    }

    public ApproveDto(Long id, boolean approve) {
        this.id = id;
        this.approve = approve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }
}
