import axios from "axios";
import React, { Component } from "react";
import { Col, Row } from "react-bootstrap";


class ContactUsRead extends Component {
  constructor(props) {
    super(props);
    this.state = {
      contactNo: "",
      contactRegId: "",
      contactEmail: "",
      contactPhone: "",
      contactContent: "",      
      crud: this.props.crud    
    };
    if(this.state.crud !== "Insert"){
        this.getData();
    }
  }

  crud() {
    const { contactNo, contactRegId, contactEmail, contactPhone, contactContent, crud } = this.state;

    let crudType = "";

    if (crud === "Insert") {
        crudType = "/insertProcess.do";
      } else if (crud === "View") {
        return null;
      }

    let form = new FormData();
    form.append("contactRegId", contactRegId);
    form.append("contactEmail", contactEmail);
    form.append("contactPhone", contactPhone);
    form.append("contactContent", contactContent);
    if (crud !== "Insert") {
      form.append("contactNo", contactNo);
    }
    axios
      .post(crudType, form)
      .then((res) => {
        alert("문의가 정상처리되었습니다");        
        window.location.replace("/");
      })
      .catch((err) => alert("error: " + err.response.data.msg));
  }


  getData(){
    axios.get("/view.do").then((res) => {
        const data = res.data;
        this.setState({
            contactNo: data.contactNo,
            contactRegId: data.contactRegId,
            contactEmail: data.contactEmail,
            contactPhone: data.contactPhone,
            contactContent: data.contactContent
        });
    });
}

createArticleIdTag(){
    const contactNo = this.state.contactNo;
    const crud = this.state.crud;
    if(crud !== "Insert"){
        return <input type="hidden" value = {contactNo || ''} readOnly />;
    } else {
        return null;
    }
}

  render() {
    const contactRegId = this.state.contactRegId;
    const contactEmail = this.state.contactEmail;
    const contactPhone = this.state.contactPhone;
    const contactContent = this.state.contactContent;

    const url = "http://localhost:3000/contactUs/insert";

    return (
        <>
        <Row className='my-5'>
        <Col className='p-5'>
          <h1 className='text-center mb-5'>Contact Us(최신 문의글 확인하기)</h1> 
                {this.createArticleIdTag()}                              
                <div className="mb-4">
                    <label htmlFor="name">이름</label>
                    <input type="text" value={contactRegId || ''} className="form-control form-control-lg" id="name" placeholder="이름을 입력해 주세요." onChange={(event) => this.setState({ contactRegId: event.target.value })} required />                    
                </div>
                <div className="mb-4">
                    <label htmlFor="email">이메일</label>
                    <input type="text" value={contactEmail || ''} className="form-control form-control-lg" id="email" placeholder="이메일을 입력해 주세요." onChange={(event) => this.setState({ contactEmail: event.target.value })}  required />                    
                </div>
                <div className="mb-4">
                    <label htmlFor="phone">연락처</label>
                    <input type="email" value={contactPhone || ''} className="form-control form-control-lg" id="phone" placeholder="연락처를 입력해 주세요." onChange={(event) => this.setState({ contactPhone: event.target.value })} required />                    
                </div>
                <div className="mb-4">
                    <label htmlFor="message" >문의 메세지를 남겨주세요.</label>
                    <textarea value={contactContent || ''} className="form-control form-control-lg" id="message" rows={5} placeholder="내용을 입력해 주세요." onChange={(event) => this.setState({ contactContent: event.target.value })} required ></textarea>                    
                </div>
                <div className="d-flex col-auto">
                    <button className="btn btn-dark btn-lg ms-auto px-5 py-3" onClick={()=>{window.open(url)}}>문의하기(등록) 바로가기</button>
                </div>
        </Col>
        </Row>
        </>
    );
  }
}

ContactUsRead.defaultProps = {  
  crud : 'View'  
}

export default ContactUsRead;