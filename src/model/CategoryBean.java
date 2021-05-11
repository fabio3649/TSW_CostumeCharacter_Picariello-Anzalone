package model;

import java.io.Serializable;

	public class CategoryBean implements Serializable {

		private static final long serialVersionUID = 1L;
		
		String idClass;
		String name;
		String description;
		
		public CategoryBean()
		{
			idClass="";
			name="";
			description="";
			
		}

		public String getIdClass() {
			return idClass;
		}

		public void setIdClass(String idClass) {
			this.idClass = idClass;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String toString()
		{
			return "[ " + this.name + " , " + this.description + " ]" ;
		}
		
}
