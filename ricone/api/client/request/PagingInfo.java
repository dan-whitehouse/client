package org.ricone.api.client.request;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
class PagingInfo {
    private Integer pageNumber;
    private Integer pageSize;

    PagingInfo(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public boolean isPaged() throws IllegalArgumentException {
        return pageNumber != null || pageSize != null;
    }

    //GETTERS & SETTERS
    Integer getPageNumber() {
        return pageNumber;
    }

    void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        PagingInfo that = (PagingInfo) o;

        if(!pageNumber.equals(that.pageNumber)) return false;
        return pageSize.equals(that.pageSize);
    }

    @Override
    public int hashCode() {
        int result = pageNumber.hashCode();
        result = 31 * result + pageSize.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PagingInfo{" + "pageNumber=" + pageNumber + ", pageSize=" + pageSize + '}';
    }
}
