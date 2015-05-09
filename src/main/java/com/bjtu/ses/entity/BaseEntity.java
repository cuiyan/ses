package com.bjtu.ses.entity;

import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseEntity implements java.io.Serializable {
	private Log log = LogFactory.getLog(AutoIDEntity.class);
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer optimistic;
	/**
	 * 创建人代码
	 */
	private String createId;
	/**
	 * 创建人名称
	 */
	private String createName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改人代码
	 */
	private String modifyId;
	/**
	 * 修改人名称
	 */
	private String modifyName;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	@Version
	public Integer getOptimistic() {
		return this.optimistic;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setOptimistic(Integer optimistic) {
		this.optimistic = optimistic;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AutoIDEntity))
			return false;
		AutoIDEntity castOther = (AutoIDEntity) other;
		return new EqualsBuilder().append(id, castOther.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public String toString() {

		StringBuilder sb = null;
		try {
			Class<?> c = this.getClass();
			Field[] fields = c.getDeclaredFields();

			sb = new StringBuilder();
			sb.append(this.getClass().getName());
			sb.append(" {");

			int i = 1;
			for (Field fd : fields) {
				fd.setAccessible(true);
				sb.append(fd.getName());
				sb.append(":");
				sb.append(fd.get(this));
				if (i != fields.length) {
					sb.append(", ");
				}
				i++;
			}
			sb.append("}");
		} catch (Exception e) {
			log.error("", e);
		}
		return sb.toString();
	}
	@Column(name = "CREATEID")
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	@Column(name = "CREATENAME")
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@Column(name = "CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "MODIFYID")
	public String getModifyId() {
		return modifyId;
	}
	public void setModifyId(String modifyId) {
		this.modifyId = modifyId;
	}
	@Column(name = "MODIFYNAME")
	public String getModifyName() {
		return modifyName;
	}
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	@Column(name = "MODIFYTIME")
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
