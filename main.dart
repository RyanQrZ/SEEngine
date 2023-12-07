// ignore_for_file: prefer_const_literals_to_create_immutables, prefer_const_constructors, use_key_in_widget_constructors

import 'package:flutter/material.dart';

void main() {
  runApp(App());
}

class App extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: ChoiceHome(),
    );
  }
}

class ChoiceHome extends StatefulWidget {
  @override
  State<ChoiceHome> createState() => _ChoiceHomeState();
}

class _ChoiceHomeState extends State<ChoiceHome> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromRGBO(255, 253, 208, 0.95),
      body: SafeArea(
        child: Center(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              //HeadText(),
              HireButton(),
              SizedBox(
                height: 50,
              ),
              RegisterButton(),
            ],
          ),
        ),
      ),
    );
  }
}

/*class HeadText extends StatelessWidget {
  const HeadText({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Text(
        "Escolha uma opcao",
        textAlign: TextAlign.center,
        style: const TextStyle(fontWeight: FontWeight.bold),
      ),
    );
  }
}*/

// Hire button
class HireButton extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: 239,
      height: 50,
      child: FilledButton.tonal(
        style: FilledButton.styleFrom(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.all(
              Radius.circular(10),),)
        ),
        onPressed: () {},
        child: Text(
          "Desejo contratar",
          style: TextStyle(fontSize: 18),
        ),
      ),
    );
  }
}

// Hire button
class RegisterButton extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: 239,
      height: 50,
      child: FilledButton.tonal(
        style: FilledButton.styleFrom(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.all(
              Radius.circular(10),),)
        ),
        onPressed: () {},
        child: Text(
          "Desejo me cadastrar",
          style: TextStyle(fontSize: 18),
        ),
      ),
    );
  }
}
