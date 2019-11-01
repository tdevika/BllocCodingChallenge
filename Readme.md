### Tasks:

- Fork a gallery app from any git repository and make it look as close as possible to the attached screenshot.
    - Used this[https://github.com/moforemmanuel/Android-Simple-Image-Gallery] sample and created the gallery screen 
    
- Create a switch view. Attached in this email there’s an .apk file that shows the default material switch view as well as our custom switch for our UI. You can either try to replicate our switch or create a new different one designed by you. (Remove the “.file” extension from the attachment)
    - Done
        - Created shape drawables for SwitchCompat to match design of given Switch
        - Copied SwitchCompat code and created CustomSwitchCompat to achieve following tasks
            - Add fade in/out animation on track
                - Added update listener to toggle animation to fade in/out track UI alpha
            - Adjust animation timing and interpolation
                - Modified THUMB_ANIMATION_DURATION = 500
                - Added LinearOutSlowInInterpolator interpolation to toggle animation
        - Remove touch ripple effect from SwitchCompat
            - Added style SwitchCompat to remove ripple effect
    - Todo
        - Add scale animation on thumb
            - Tried animating thumb drawable but couldn't achieve same behaviour
            
