Why can't enum have public constructors?
- because you cant make instances from outside, (using new) and go outside of the fixed set of constants.
Enum can be declared inside or outside a class, but not inside a method.
