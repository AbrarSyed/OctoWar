if !File.exist?('.keystore') then
	puts 'Generating keystore file ... password: gdxpassword (valid for 10 years)'
	`keytool -genkey -alias gdxkey -keypass gdxpassword -validity 3650 -keystore .keystore`
else
	puts 'Using existing keystore file ...'
end

jars = Dir.glob('*.jar')
jars.each do |jar|
	`jarsigner -keystore .keystore -storepass gdxpassword #{jar} gdxkey`
	puts "Signed #{jar}!"
end
