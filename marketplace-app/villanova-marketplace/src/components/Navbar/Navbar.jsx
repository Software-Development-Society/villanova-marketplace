import React, { useState } from "react";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import InputBase from "@material-ui/core/InputBase";
import SearchIcon from "@material-ui/icons/Search";
import { Link } from "react-router-dom";
import "./Navbar.css";

export default function Navbar() {
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false);

  const handleMobileMenuOpen = () => {
    setMobileMenuOpen(true);
  };

  const handleMobileMenuClose = () => {
    setMobileMenuOpen(false);
  };

  return (
    <div className="root">
      <AppBar position="static" className="AppBar">
        <Toolbar className="toolbar">
          <div className="search">
            <div className="searchIcon">
              <SearchIcon />
            </div>
            <InputBase
              placeholder="Search…"
              classes={{
                root: "inputRoot",
                input: "inputInput",
              }}
              inputProps={{ "aria-label": "search" }}
            />
          </div>
          <div className="wrapperDiv">
            <div className="navLinks">
              <Button color="inherit" component={Link} to="/">
                Home
              </Button>
              <Button color="inherit" component={Link} to="/marketplace">
                Marketplace
              </Button>
              <Button color="inherit" component={Link} to="/account">
                Account
              </Button>
            </div>
            <IconButton
              edge="end"
              className="menuButton"
              color="inherit"
              aria-label="menu"
              onClick={handleMobileMenuOpen}
            >
              <MenuIcon />
            </IconButton>
          </div>
        </Toolbar>
      </AppBar>
      <div
        className="mobileMenu"
        style={{ display: mobileMenuOpen ? "flex" : "none" }}
      >
        <Button
          color="inherit"
          component={Link}
          to="/"
          onClick={handleMobileMenuClose}
        >
          Home
        </Button>
        <Button
          color="inherit"
          component={Link}
          to="/marketplace"
          onClick={handleMobileMenuClose}
        >
          Marketplace
        </Button>
        <Button
          color="inherit"
          component={Link}
          to="/account"
          onClick={handleMobileMenuClose}
        >
          Account
        </Button>
      </div>
    </div>
  );
}
