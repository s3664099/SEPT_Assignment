import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import AuthenticatedRoute from './AuthenticatedRoute.jsx'
import ErrorComponent from './ErrorComponent.jsx'
import HeaderComponent from './HeaderComponent.jsx'
import LoginComponent from './login/LoginComponent.jsx'
import LogoutComponent from './login/LogoutComponent.jsx'
import WelcomeComponent from './welcome/WelcomeComponent.jsx'
import ListTodosComponent from './todo/ListTodosComponent.jsx'
import TodoComponent from './todo/TodoComponent.jsx'
import WallComponent from './wall/WallComponent'
import NewPost from './wall/NewPost.jsx'
import OtherWall from './wall/OtherWall'

class WelcomeApp extends Component {
    render() {
        return (
            <div className="WelcomeApp">
                <Router>
                    <>
                        <HeaderComponent/>
                        <Switch>
                            <Route path="/" exact component={LoginComponent}/>
                            <Route path="/login" component={LoginComponent}/>
                            <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}/>
                            <AuthenticatedRoute path="/todos/:id" component={TodoComponent}/>
                            <AuthenticatedRoute path="/todos" component={ListTodosComponent}/>
                            <AuthenticatedRoute path="/logout" component={LogoutComponent}/>
                            <AuthenticatedRoute path="/otherWall/:name" component={OtherWall}/>
                            <AuthenticatedRoute path="/wall/:postId" component={NewPost}/>
                            <AuthenticatedRoute path="/wall" component ={WallComponent}/>

                            <Route component={ErrorComponent}/>
                        </Switch>
                    </>
                </Router>
                {/*<LoginComponent/>
                <WelcomeComponent/>*/}
            </div>
        )
    }
}

export default WelcomeApp
