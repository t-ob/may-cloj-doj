(ns for-the-glory-of-art
  (:use quil.core))

(def active-piece (atom [0 0]))
(def square-size 20)
(def board-height 600)
(def board-width 800)

(defn key-typed? []
  (swap! active-piece (fn [[x y]] [(min (- board-width square-size) (+ square-size x)) y])))

(defn tick []
  (swap! active-piece (fn [[x y]] [x (min (- board-height square-size) (+ square-size y))])))

(defn clear [] (background-float 0))

(defn tetris-draw []
  (let [[x y] @active-piece]
    (tick)
    (clear)
    (rect x y square-size square-size)))

(defn tetris-setup []
  (smooth)                          ;;Turn on anti-aliasing
  (frame-rate 2)                    
  (background 200))                 ;;Set the background colour to

(defsketch example
  :title "Oh so many grey hexagons"
  :setup tetris-setup
  :draw tetris-draw
  :size [board-width board-height]
  :key-released key-typed?)
