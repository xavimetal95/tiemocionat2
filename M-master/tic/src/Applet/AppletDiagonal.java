/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet;

/**
 *
 * @author TicEmocionat
 */

import java.awt.*;
import java.applet.*;
public class AppletDiagonal extends Applet {
 public void paint(Graphics g) {
    g.setColor( Color.GREEN );
    g.drawLine(0, 0, getWidth(), getHeight() );
    g.setColor( Color.RED );
    g.drawString("AppletDiagonal",5,50);
 }
}