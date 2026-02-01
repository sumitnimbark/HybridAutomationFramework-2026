package com.pojo;

public class StoreOrderPOJO {

		private final int id;
		private int petId;
		private int quantity;
		private String date;
		private boolean complete;
		
		public StoreOrderPOJO(int id, int petId, int quantity, String date, boolean complete) {
			super();
			this.id = id;
			this.petId = petId;
			this.quantity = quantity;
			this.date = date;
			this.complete = complete;
		}
		
		public int getPetId() {
			return petId;
		}
		public void setPetId(int petId) {
			this.petId = petId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public boolean isComplete() {
			return complete;
		}
		public void setComplete(boolean complete) {
			this.complete = complete;
		}
		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return "StoreOrderPOJO [id=" + id + ", petId=" + petId + ", quantity=" + quantity + ", date=" + date
					+ ", complete=" + complete + "]";
		}

}
