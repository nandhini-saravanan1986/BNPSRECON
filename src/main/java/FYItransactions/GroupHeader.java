package FYItransactions;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrpHdr", propOrder = {
	"grpHdrMessageIdentifier",
	"grpHdrCreationDateTime",
	"msgRcpt",
	"msgPgntn"
})
public class GroupHeader {
	@XmlElement(name = "MsgId", required = true)
    protected String grpHdrMessageIdentifier;
	
	@XmlElement(name = "CreDtTm", required = true)
    protected Date grpHdrCreationDateTime;
	
	@XmlElement(name = "MsgRcpt", required = true)
	protected MessageRecipient msgRcpt;

	@XmlElement(name = "MsgPgntn", required = true)
	protected MessagePagination msgPgntn;

	public String getGrpHdrMessageIdentifier() {
		return grpHdrMessageIdentifier;
	}

	public void setGrpHdrMessageIdentifier(String grpHdrMessageIdentifier) {
		this.grpHdrMessageIdentifier = grpHdrMessageIdentifier;
	}

	public Date getGrpHdrCreationDateTime() {
		return grpHdrCreationDateTime;
	}

	public void setGrpHdrCreationDateTime(Date grpHdrCreationDateTime) {
		this.grpHdrCreationDateTime = grpHdrCreationDateTime;
	}

	public MessageRecipient getMsgRcpt() {
		return msgRcpt;
	}

	public void setMsgRcpt(MessageRecipient msgRcpt) {
		this.msgRcpt = msgRcpt;
	}

	public MessagePagination getMsgPgntn() {
		return msgPgntn;
	}

	public void setMsgPgntn(MessagePagination msgPgntn) {
		this.msgPgntn = msgPgntn;
	}
}