package com.vg.cutomermanagement.response;

public class OperationResponseDto<Status, D> {

    public enum Status {
        SUCCESS,
        FIRST_NAME_NOT_PRESENT,
        ERROR
    }
 	
	Status status;
	D data;
	
	public OperationResponseDto() {
		
	}
	
	public OperationResponseDto(Status status, D data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public D getData() {
		return data;
	}

	public void setMessage(D data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationResponseDto other = (OperationResponseDto) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (status != other.status)
			return false;
		return true;
	}



}
